package fr.dawan.bibliotheque.services;

import fr.dawan.bibliotheque.dtos.BorrowDto;
import fr.dawan.bibliotheque.entities.Borrow;
import fr.dawan.bibliotheque.entities.exceptions.IdNotFoundException;
import fr.dawan.bibliotheque.mappers.BorrowMapper;
import fr.dawan.bibliotheque.repositories.BorrowRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@Validated
public class BorrowServiceImpl implements IBorrowService{

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BorrowMapper borrowMapper;

    @Override
    @Transactional
    public Borrow getById(long id) {
        Borrow borrow = borrowRepository.findById(id).get();
        return borrow;
    }


    @Override
    @Transactional
    public List<Borrow> getByBorrowDate(LocalDate borrowDate) {
        return borrowRepository.getByBorrowDate(borrowDate);
    }

    @Override
    @Transactional
    public List<Borrow> getByBorrowReturnDate(LocalDate borrowReturnDate) {
        return borrowRepository.findByBorrowReturnDate(borrowReturnDate);
    }

    @Override
    @Transactional
    public BorrowDto addBorrow(BorrowDto borrowDto) {

        Borrow borrow = borrowMapper.toEntity(borrowDto);

        Borrow saveBorrow = borrowRepository.saveAndFlush(borrow);

        BorrowDto updateDto = borrowMapper.toDto(saveBorrow);

        return updateDto;
    }


    @Override
    public void deleteById(long id) {
        if(borrowRepository.removeById(id) == 0){
            throw new IdNotFoundException();
        }
    }

    @Override
    public BorrowDto updateBorrow(BorrowDto borrowDto) {
        Borrow borrow = borrowRepository.findById(borrowDto.getId()).orElseThrow(
                () -> new IdNotFoundException(borrowDto.getId() + "Not found0"));
        borrowMapper.update(borrowDto, borrow);
        return borrowMapper.toDto(borrowRepository.save(borrow));
    }

}






