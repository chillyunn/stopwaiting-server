package com.stopwaiting.server.web.api;

import com.stopwaiting.server.domain.waitingInfo.WaitingInfoRepository;
import com.stopwaiting.server.service.waitinginfo.WaitingInfoService;
import com.stopwaiting.server.web.dto.waitinginfo.WaitingInfoResponseDto;
import com.stopwaiting.server.web.dto.waitinginfo.WaitingInfoSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class WaitingInfoApiController {
    private final WaitingInfoService waitingInfoService;

    @PostMapping("/api/v1/waitinginfo")
    public Long save(@RequestBody WaitingInfoSaveRequestDto requestDto) throws IOException {
        return waitingInfoService.save(requestDto);
    }
    @GetMapping("/api/v1/waitinginfo")
    public JSONObject findAll(){
        return waitingInfoService.findAll();
    }
    @GetMapping("/api/v1/waitinginfo/{id}")
    public WaitingInfoResponseDto findById(@PathVariable Long id) { return waitingInfoService.findById(id);}





//  @PutMapping("/api/v1/waitinginfo")

}
