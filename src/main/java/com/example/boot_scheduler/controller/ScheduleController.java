package com.example.boot_scheduler.controller;

import com.example.boot_scheduler.dto.ScheduleRequestDto;
import com.example.boot_scheduler.dto.ScheduleResponseDto;
import com.example.boot_scheduler.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    //일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto dto){
        long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
        Schedule schedule = new Schedule(scheduleId, dto.getTodo_title(), dto.getTodo_contents(), dto.getAuthor(), dto.getPassword(), LocalDateTime.now());        scheduleList.put(scheduleId, schedule);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.CREATED);
    }

    //전체 일정 조회
    @GetMapping
    public List<ScheduleResponseDto> finalAllSchedules(){
        List<ScheduleResponseDto> responseList = new ArrayList<>();

        for(Schedule schedule : scheduleList.values()){
            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
            responseList.add(responseDto);
        }

        return responseList;
    }
    //고유 식별자(id)를 통한 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id){
        Schedule schedule = scheduleList.get(id);

        if(schedule == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
    }
    //author를 통한 동일 작성자의 모든 일정 조회
    @GetMapping("/author/{author}")
    public ResponseEntity<List<ScheduleResponseDto>> findSchedulesByAuthor(@PathVariable String author){
        List<ScheduleResponseDto> responseList = new ArrayList<>();

        for (Schedule schedule : scheduleList.values()) {
            if (schedule.getAuthor().equals(author)) {
                responseList.add(new ScheduleResponseDto(schedule));
            }
        }

        if (responseList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        if(schedule == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
    //date를 통한 동일 날짜의 모든 일정 조회
    @GetMapping("/date/{date}")
    public ResponseEntity<List<ScheduleResponseDto>> findSchedulesByDate(@PathVariable String date) {
        LocalDateTime localDateTime = LocalDateTime.parse(date + "T00:00:00");
        List<ScheduleResponseDto> responseList = new ArrayList<>();

        for (Schedule schedule : scheduleList.values()) {
            if (schedule.getDate().toLocalDate().isEqual(localDateTime.toLocalDate())) {
                responseList.add(new ScheduleResponseDto(schedule));
            }
        }

        if (responseList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
    //
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto dto){
        Schedule schedule = scheduleList.get(id);

        if(schedule == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (schedule.getPassword() != dto.getPassword()) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        Schedule updatedSchedule = new Schedule(id, schedule.getTodo_title(), dto.getTodo_contents(), schedule.getAuthor(), schedule.getPassword(), LocalDateTime.now());
        scheduleList.put(id, updatedSchedule);

        return new ResponseEntity<>(new ScheduleResponseDto(updatedSchedule), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id, @RequestBody Map<String, Integer> password){

        Schedule schedule = scheduleList.get(id);
        if (scheduleList.containsKey(id)){
            scheduleList.remove(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        if (schedule.getPassword() != password.get("password")) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN); // 비밀번호가 일치하지 않음
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}
