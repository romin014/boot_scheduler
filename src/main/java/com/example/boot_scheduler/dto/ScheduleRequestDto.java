package com.example.boot_scheduler.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {
    private String todo_title;
    private String todo_contents;
    private String author;
    private int password;
    private LocalDateTime date;
}
