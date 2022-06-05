package com.stopwaiting.server.web.api;

import com.stopwaiting.server.domain.userqueue.UserQueue;
import com.stopwaiting.server.service.UserQueueService;
import com.stopwaiting.server.web.dto.userqueue.UserQueueResponseDto;
import com.stopwaiting.server.web.dto.userqueue.UserQueueSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserQueueApiController {
    private final UserQueueService userQueueService;

    @PostMapping("api/v1/waitinginfo/{id}/queue/{time}")
    public Long save(@PathVariable Long id, @PathVariable String time, @RequestBody UserQueueSaveRequestDto requestDto) {
        return userQueueService.save(id, time, requestDto);
    }

    @GetMapping("api/v1/user/{id}/queue")
    public JSONObject findQueueByUser(@PathVariable Long id) {
        return userQueueService.findQueueByUser(id);
    }
}
