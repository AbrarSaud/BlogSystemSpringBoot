package com.example.lab11.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "The user name must not be empty")
    @Size(min = 4, message = "The 'user name' be more than 4 length long")
    @Column(columnDefinition = "varchar(150) not null unique")
    private String user_name;

    @NotEmpty(message = "The password must not be empty")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).{7,}$", message = "Password must contain at least one letter and one number")
    @Column(columnDefinition = "varchar(255) not null")
    private String password;

    @NotEmpty(message = "The email must not be empty")
    @Email()
    @Column(columnDefinition = "varchar(255) not null unique")
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private LocalDate registration_date;

}
