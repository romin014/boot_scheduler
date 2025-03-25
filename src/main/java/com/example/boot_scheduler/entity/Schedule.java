package com.example.boot_scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String todo_title;
    private String todo_contents;
    private String author;
    private int password;
    private LocalDateTime date;
}
