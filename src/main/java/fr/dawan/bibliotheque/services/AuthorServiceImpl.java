package fr.dawan.bibliotheque.services;

import com.opencsv.CSVReader;
import fr.dawan.bibliotheque.dtos.AuthorDto;
import fr.dawan.bibliotheque.entities.Author;
import fr.dawan.bibliotheque.entities.exceptions.IdNotFoundException;
import fr.dawan.bibliotheque.mappers.AuthorMapper;
import fr.dawan.bibliotheque.repositories.AuthorRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Validated
public class AuthorServiceImpl implements IAuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    //get author by id

    @Override
    @Transactional
    public Author getById(long id) {
        Author authors = authorRepository.findById(id).get();
        return authors;
        // OR simply return authorRepository.findById(id).get();
    }

    //Get author by name
    @Override
    @Transactional
    public List<Author> getByName(String name) {
        List<Author> authors = authorRepository.findByNameLike(name + "%");

        return authors;
    }


    //Add (POST method) an author to the database
    public AuthorDto addAuthor(AuthorDto authorDto) {

        //Convert a Dto to en Entity
        Author author = authorMapper.toEntity(authorDto);

        //Use the Entity Author to save in the database
        Author saveAuthor = authorRepository.saveAndFlush(author);

        //Convert the saved Entity back to a Dto
        AuthorDto resultDto = authorMapper.toDto(saveAuthor);

        return  resultDto;
    }


    //Update an author with id
    @Override
    public AuthorDto updateAuthor(AuthorDto  authorDto) {

        Author author = authorRepository.findById(authorDto.getId())
                .orElseThrow(() -> new IdNotFoundException("Author with " + authorDto.getId() + " not found"));

        authorMapper.update(authorDto, author);
        return authorMapper.toDto(authorRepository.save(author));
    }


    //Delete an author from database using his id
    @Override
    public void deleteById(long id) {
        if(authorRepository.removeById(id) == 0) {
            throw new IdNotFoundException();
        }

    }

    @Override
    public void saveAuthorsFromCSV(MultipartFile file){

        try (Reader reader = new InputStreamReader(file.getInputStream());
            CSVReader csvReader = new CSVReader(reader)) {

            List<Author> authors = new ArrayList<>();
            String[] line;
            boolean firstLine = true;

            while ((line = csvReader.readNext()) != null) {

                if(firstLine) {
                    firstLine = false;
                    continue;
                }

                String name = line[0].trim();
                String firstName = line[1].trim();
                String dateOfBirth = line[2].trim();
                String nationality = line[3].trim();
                String description = line[4].trim();
                String bookNumbers = line[5].trim();

                if(!authorRepository.existsByName(name)) {
                    //localdate and int from string to format real - date of birth and book numbers
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate formattedDateOfBirth = LocalDate.parse(dateOfBirth.trim(), formatter);

                    int bookCounts = Integer.parseInt(bookNumbers);
                    Author author = new Author(name, firstName, formattedDateOfBirth, nationality, description, bookCounts);
                    authors.add(author);


                }
            }
            authorRepository.saveAll(authors);
        }catch (Exception e) {
            throw new RuntimeException("Error processing CSV file: " + e.getMessage());
        }

    }
}
