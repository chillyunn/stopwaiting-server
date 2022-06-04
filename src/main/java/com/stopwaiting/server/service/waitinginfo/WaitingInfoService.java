package com.stopwaiting.server.service.waitinginfo;

import com.stopwaiting.server.domain.timetable.Timetable;
import com.stopwaiting.server.domain.timetable.TimetableRepository;
import com.stopwaiting.server.domain.waitingInfo.WaitingInfo;
import com.stopwaiting.server.domain.waitingInfo.WaitingInfoRepository;
import com.stopwaiting.server.web.dto.timetable.TimetableSaveRequestDto;
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

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class WaitingInfoService {
    private final WaitingInfoRepository waitingInfoRepository;
    private final TimetableRepository timetableRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public Long save(WaitingInfoSaveRequestDto requestDto) throws IOException {
        Long id =waitingInfoRepository.save(requestDto.toEntity()).getId();
        for(String timetable:requestDto.getTimetables()){
            timetableRepository.save(
                    new TimetableSaveRequestDto(waitingInfoRepository.findById(id).
                    orElseThrow(()->new IllegalArgumentException("존재하지 않는 WaitingInfo"))
                            ,timetable).toEntity());
        }
        return id;
    }

    @Transactional(readOnly = true)
    public JSONObject findAll() {
        JSONObject jsonMain = new JSONObject();
        jsonMain.put("data", waitingInfoRepository.findAll()
                .stream()
                .map(waitingInfo -> modelMapper.map(waitingInfo, WaitingInfoResponseDto.class)).collect(Collectors.toList()));
        return jsonMain;
    }
//    @Transactional
//    public Long update(Long id)

    public WaitingInfoResponseDto findById(Long id) {
        WaitingInfo entity = waitingInfoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 웨이팅정보가 없습니다."));
        return new WaitingInfoResponseDto(entity);
    }
}
