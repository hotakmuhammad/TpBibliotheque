package fr.dawan.bibliotheque.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Builder
public class UserDto {

    @PositiveOrZero(message = "Id must be positive or zero")
    private  long id;

    @NotNull
    private String name;

    @NotNull
    private  String firstName;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private String email;

    @NotNull
    private String adress;

    @NotNull
    private  long phoneNumber;

    @NotNull
    private boolean anAdult;
}
