package fr.dawan.bibliotheque.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import fr.dawan.bibliotheque.dtos.BorrowDto;
import fr.dawan.bibliotheque.entities.Borrow;
import fr.dawan.bibliotheque.services.IBorrowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@Slf4j

@RestController
@RequestMapping("/api/biblio")
public class BorrowsController {

    @Autowired
    private IBorrowService borrowService;

    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping(value = "/find-borrow/{id}")
    public Borrow getById(@PathVariable long id) {
        return borrowService.getById(id);
    }


    @GetMapping(value = "/borrow-date")
    public List<Borrow> getByBorroDate(@RequestParam LocalDate borrowDate) {
        return borrowService.getByBorrowDate(borrowDate);
    }

    @GetMapping(value = "/return-date")
    public List<Borrow> getByReturnDate(@RequestParam LocalDate borrowReturnDate) {
        return borrowService.getByBorrowReturnDate(borrowReturnDate);
    }

    @PostMapping(value = "/add-borrow")
    public BorrowDto addBorrow(@RequestBody BorrowDto borrowDto) {

        return borrowService.addBorrow(borrowDto);
    }

    @PutMapping(value = "/updateBorrow")
    public BorrowDto updateBorrow(@RequestBody BorrowDto updateBorrow){

        return borrowService.updateBorrow(updateBorrow);
    }

    /*
    example of json request body
    {
    "id" : 4,
    "borrowDate": "2024-02-10",
    "borrowReturnDate": "2025-02-11",
    "status" : "BORROWED",
    "user" :
        {
            "id" : 2,
            "name" : "U-2",
            "firstName" : "T-2",
            "dateOfBirth" : "2025-02-13",
            "Email" : "hghgy@jhj.vkj",
            "adress" : "1 rue de one charles de apple",
            "phoneNumber" : "0124505054255",
            "isAnAdult" : true
        }

}
     */
    @DeleteMapping(value = "/delete-borrow/{id}")
    public String deleteById(@PathVariable long id) {
        borrowService.deleteById(id);
        return "L'id : " + id + " est bien supprimé";

    }

}
