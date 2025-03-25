package com.example.boot_scheduler.controller;

import com.example.boot_scheduler.dto.ScheduleRequestDto;
import com.example.boot_scheduler.dto.ScheduleResponseDto;
import com.example.boot_scheduler.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
public class ScheduleController {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto dto){
        long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
        Schedule schedule = new Schedule(scheduleId, dto.getTodo_title(), dto.getTodo_contents(), dto.getAuthor(), dto.getPassword(), dto.getDate_of_creation(), dto.getDate_of_modification());
        scheduleList.put(scheduleId, schedule);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ScheduleResponseDto> finalAllSchedules(@PathVariable String author){
        List<ScheduleResponseDto> responseList = new ArrayList<>();

        for(Schedule schedule : scheduleList.values()){
            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
            responseList.add(responseDto);
        }

        return responseList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id){
        Schedule schedule = scheduleList.get(id);

        if(schedule == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){

        if (scheduleList.containsKey(id)){
            scheduleList.remove(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
