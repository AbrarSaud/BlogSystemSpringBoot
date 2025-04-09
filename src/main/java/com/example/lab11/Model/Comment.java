package com.example.lab11.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "The user_id must not be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;

    @NotNull(message = "The post_id must not be null")
    @Column(columnDefinition = "int not null")
    private Integer postId;

    @NotEmpty(message = "The Content must not be empty")
    @Size(min = 50, message = "The Content  be more than 50 length")
    @Column(columnDefinition = "varchar(150) not null ")
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private LocalDate comment_date;

}
