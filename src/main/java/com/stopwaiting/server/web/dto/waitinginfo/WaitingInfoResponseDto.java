package com.stopwaiting.server.web.dto.waitinginfo;

import com.stopwaiting.server.domain.waitingInfo.Type;
import com.stopwaiting.server.domain.waitingInfo.WaitingInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
public class WaitingInfoResponseDto {
    private Long adminId;
    private double latitude;
    private double longitude;
    private String name;
    private String locationDetail;
    private String information;
    private Type type;
    private int maxPerson;
    private Set<String> timetables=new HashSet<>();

    public WaitingInfoResponseDto(WaitingInfo entity){
        this.adminId= entity.getAdminId();
        this.latitude=entity.getLatitude();
        this.longitude= entity.getLongitude();
        this.name= entity.getName();
        this.locationDetail= entity.getLocationDetail();
        this.information= entity.getInformation();
        this.type=entity.getType();
        this.maxPerson= entity.getMaxPerson();
        this.timetables=entity.getTimetables();
    }
}
