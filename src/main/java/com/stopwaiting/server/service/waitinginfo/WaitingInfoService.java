package com.stopwaiting.server.service.waitinginfo;

import com.stopwaiting.server.domain.waitingInfo.WaitingInfo;
import com.stopwaiting.server.domain.waitingInfo.WaitingInfoRepository;
import com.stopwaiting.server.web.dto.waitinginfo.WaitingInfoResponseDto;
import com.stopwaiting.server.web.dto.waitinginfo.WaitingInfoSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WaitingInfoService {
    private final WaitingInfoRepository waitingInfoRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public Long save(WaitingInfoSaveRequestDto requestDto) {
        return waitingInfoRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
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

}
