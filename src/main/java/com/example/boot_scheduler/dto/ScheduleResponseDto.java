package com.example.boot_scheduler.dto;

import com.example.boot_scheduler.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String todo_title;
    private String todo_contents;
    private String author;
    private int password;
    private String date_of_creation;
    private String date_of_modification;

    public ScheduleResponseDto(Schedule schedule){
        this.id = schedule.getId();
        this.todo_title = schedule.getTodo_title();
        this.todo_contents = schedule.getTodo_contents();
        this.author = schedule.getAuthor();
        this.password = schedule.getPassword();
        this.date_of_creation = schedule.getDate_of_creation();
        this.date_of_modification = schedule.getDate_of_modification();
    }
}
