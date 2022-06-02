package com.stopwaiting.server.service.waitinginfo;

import com.stopwaiting.server.domain.waitingInfo.WaitingInfo;
import com.stopwaiting.server.domain.waitingInfo.WaitingInfoRepository;
import com.stopwaiting.server.web.dto.waitinginfo.WaitingInfoResponseDto;
import com.stopwaiting.server.web.dto.waitinginfo.WaitingInfoSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class WaitingInfoService {
    private final WaitingInfoRepository waitingInfoRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public Long save(WaitingInfoSaveRequestDto requestDto) throws IOException {
        return waitingInfoRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
//    public List<WaitingInfoResponseDto> findAll(){
    public JSONObject findAll() {

        JSONObject jsonMain = new JSONObject();
        jsonMain.put("data", waitingInfoRepository.findAll()
                .stream()
                .map(waitingInfo -> modelMapper.map(waitingInfo, WaitingInfoResponseDto.class)).collect(Collectors.toList()));
//        return waitingInfoRepository.findAll()
//                .stream()
//                .map(waitingInfo -> modelMapper.map(waitingInfo, WaitingInfoResponseDto.class)).collect(Collectors.toList());
        return jsonMain;
    }
//    @Transactional
//    public Long update(Long id)

    public WaitingInfoResponseDto findById(Long id) {
        WaitingInfo entity = waitingInfoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 웨이팅정보가 없습니다."));
        return new WaitingInfoResponseDto(entity);
    }
}
