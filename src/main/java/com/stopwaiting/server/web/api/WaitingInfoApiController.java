package com.stopwaiting.server.web.api;

import com.stopwaiting.server.domain.waitingInfo.WaitingInfoRepository;
import com.stopwaiting.server.service.waitinginfo.WaitingInfoService;
import com.stopwaiting.server.web.dto.waitinginfo.WaitingInfoResponseDto;
import com.stopwaiting.server.web.dto.waitinginfo.WaitingInfoSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WaitingInfoApiController {
    private final WaitingInfoService waitingInfoService;

    @PostMapping("/api/v1/waitinginfo")
    public Long save(@RequestBody WaitingInfoSaveRequestDto requestDto) {
        return waitingInfoService.save(requestDto);
    }
    @GetMapping("/api/v1/waitinginfo")
//    public List<WaitingInfoResponseDto> findAll(){
    public JSONObject findAll(){
        return waitingInfoService.findAll();
    }
//    @PutMapping("/api/v1/waitinginfo")
}
