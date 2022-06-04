package com.stopwaiting.server.web.api;

import com.stopwaiting.server.domain.waitingQueue.WaitingQueue;
import com.stopwaiting.server.service.waitingqueue.WaitingQueueService;
import com.stopwaiting.server.web.dto.waitingqueue.WaitingQueueRequestDto;
import com.stopwaiting.server.web.dto.waitingqueue.WaitingQueueResponseDto;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class WaitingQueueApiController {
    private final WaitingQueueService waitingQueueService;

    @PostMapping("/api/v1/waitinginfo/{id}/queue")
    public Long save(@PathVariable Long id, @RequestBody WaitingQueueRequestDto requestDto){
        return waitingQueueService.save(id,requestDto);
    }
    @GetMapping("/api/v1/waitinginfo/queues")
    public JSONObject findAll(){
        return  waitingQueueService.findAll();
    }

}
