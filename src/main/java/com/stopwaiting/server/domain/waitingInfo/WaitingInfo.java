package com.stopwaiting.server.domain.waitingInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stopwaiting.server.domain.BaseTimeEntity;
import com.stopwaiting.server.domain.image.WaitingInfoImage;
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
public class WaitingInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private Long adminId;

    @Column(nullable = false)
    private String locationDetail;

    @Column(nullable = false)
    private String information;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column
    private Integer maxPerson;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @ElementCollection
    private Set<String> timetables=new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "waitingInfo",cascade = CascadeType.ALL)
    private List<WaitingInfoImage> images = new ArrayList<>();

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

    public void addImages(WaitingInfoImage image){
        this.images.add(image);
        image.updateWaitinginfo(this);
    }
}
