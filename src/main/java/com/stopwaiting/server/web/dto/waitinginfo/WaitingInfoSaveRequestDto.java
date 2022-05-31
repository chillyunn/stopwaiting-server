package com.stopwaiting.server.web.dto.waitinginfo;

import com.stopwaiting.server.domain.waitingInfo.Type;
import com.stopwaiting.server.domain.waitingInfo.WaitingInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
public class WaitingInfoSaveRequestDto {
    private Long adminId;
    private double latitude;
    private double longitude;
    private String name;
    private String locationDetail;
    private String information;
    private Type type;
    private int maxPerson;
    private Set<String> timetables = new HashSet<>();
    private Set<String> images = new HashSet();

    @Builder
    public WaitingInfoSaveRequestDto(Long adminId, double latitude, double longitude,
                                     String name, String locationDetail, String information,
                                     Type type, int maxPerson, Set<String> timetables,Set<String> images) {
        this.adminId = adminId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.locationDetail = locationDetail;
        this.information = information;
        this.type = type;
        this.maxPerson = maxPerson;
        this.timetables = timetables;
        this.images=images;
    }

    public WaitingInfo toEntity(String location) {

        return WaitingInfo.builder()
                .adminId(adminId)
                .latitude(latitude)
                .longitude(longitude)
                .name(name)
                .locationDetail(locationDetail)
                .information(information)
                .type(type)
                .maxPerson(maxPerson)
                .timetables(timetables)
                .images(location)
                .build();
    }
}
