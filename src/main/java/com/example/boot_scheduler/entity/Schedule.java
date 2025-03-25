package com.example.boot_scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String todo_title;
    private String todo_contents;
    private String author;
    private int password;
    private String date_of_creation;
    private String date_of_modification;

}
