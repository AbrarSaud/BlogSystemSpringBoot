package com.example.lab11.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "The category_id must not be null")
    @Column(columnDefinition = "int not null")
    private Integer categoryId;


    @NotEmpty(message = "The Title must not be empty")
    @Size(min = 4, message = "The Title be more than 4 length")
    @Column(columnDefinition = "varchar(150) not null ")
    private String title;

    @NotEmpty(message = "The Content must not be empty")
    @Size(min = 50, message = "The Content  be more than 50 length")
    @Column(columnDefinition = "varchar(150) not null ")
    private String content;

    @NotNull(message = "The user_id must not be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private LocalDate publish_date;

}
