package com.stopwaiting.server.domain.image;

import com.stopwaiting.server.domain.BaseTimeEntity;
import com.stopwaiting.server.domain.waitingInfo.WaitingInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class WaitingInfoImage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WAITINGINFO_ID")
    private WaitingInfo waitingInfo;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private String fileurl;

    @Builder
    public WaitingInfoImage(WaitingInfo waitingInfo,String filename, String fileurl) {
        this.waitingInfo=waitingInfo;
        this.waitingInfo.getImages().add(this);
        this.filename = filename;
        this.fileurl = fileurl;
    }

    public void updateWaitinginfo(WaitingInfo waitingInfo){
        this.waitingInfo=waitingInfo;
    }
}
