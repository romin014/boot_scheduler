package com.example.boot_scheduler.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String todo_title;
    private String todo_contents;
    private String author;
    private int password;
    private String date_of_creation;
    private String date_of_modification;
}
