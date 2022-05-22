package com.stopwaiting.server.domain.waitingInfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class WaitingInfoTest {

    @Autowired
    WaitingInfoRepository waitingInfoRepository;

    @Test
    void WaitingInfo_저장() throws Exception{
        //given
        String name = "kim";
        String admin = "han";
        String locDetail = "금오공대";
        String info="미용실";
        Type type=Type.NORMAL;
        int maxPerson=5;
        double latitude=50.324;
        double longitude=50.12;
        Set<String> timetables= new HashSet<>(Arrays.asList("12:00","13:00","15:00"));

        waitingInfoRepository.save(WaitingInfo.builder()
                .name(name)
                .admin(admin)
                .locDetail(locDetail)
                .info(info)
                .type(type)
                .maxPerson(maxPerson)
                .latitude(latitude)
                .longitude(longitude)
                .timetables(timetables)
                .build());
        //when
        List<WaitingInfo> waitingInfos = waitingInfoRepository.findAll();
        //then
        WaitingInfo waitingInfo = waitingInfos.get(0);

        assertThat(waitingInfo.getAdmin()).isEqualTo(admin);
        assertThat(waitingInfo.getLatitude()).isEqualTo(latitude);

    }

}