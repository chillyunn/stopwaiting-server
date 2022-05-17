package com.stopwaiting.server.domain.waitingInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private String admin;

    @Column
    private String locDetail;

    @Column
    private String info;

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

    public WaitingInfo(String name, String admin, String locDetail, String info, Type type, int maxPerson, double latitude, double longitude, Set<String> timetables) {
        this.name = name;
        this.admin = admin;
        this.locDetail = locDetail;
        this.info = info;
        this.type = type;
        this.maxPerson = maxPerson;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timetables = timetables;
    }
}
