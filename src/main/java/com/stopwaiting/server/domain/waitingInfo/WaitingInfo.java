package com.stopwaiting.server.domain.waitingInfo;

import com.stopwaiting.server.web.dto.waitinginfo.WaitingInfoResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
public class WaitingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;


    @Column
    private Long adminId;

    @Column
    private String locationDetail;

    @Column
    private String information;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column
    private int maxPerson;

    @Column
    private double latitude;

    @Column
    private double longitude;

    @ElementCollection
    private Set<String> timetables=new HashSet<>();

    @Builder
    public WaitingInfo(String name, Long adminId, String locationDetail, String information, Type type, int maxPerson, double latitude, double longitude, Set<String> timetables) {
        this.name = name;
        this.adminId = adminId;
        this.locationDetail = locationDetail;
        this.information = information;
        this.type = type;
        this.maxPerson = maxPerson;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timetables = timetables;
    }
}
