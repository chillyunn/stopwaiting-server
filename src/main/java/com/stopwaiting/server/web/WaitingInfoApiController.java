package com.stopwaiting.server.web;

import com.stopwaiting.server.domain.waitingInfo.WaitingInfoRepository;
import com.stopwaiting.server.service.waitinginfo.WaitingInfoService;
import com.stopwaiting.server.web.dto.waitinginfo.WaitingInfoResponseDto;
import com.stopwaiting.server.web.dto.waitinginfo.WaitingInfoSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public List<WaitingInfoResponseDto> findAll(){
        return waitingInfoService.findAll();
    }
}
