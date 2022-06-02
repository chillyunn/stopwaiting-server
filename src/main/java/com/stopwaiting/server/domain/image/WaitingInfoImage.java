package com.stopwaiting.server.domain.image;

import com.stopwaiting.server.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class WaitingInfoImage extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private String fileurl;

    @Builder
    public WaitingInfoImage(String filename, String fileurl) {
        this.filename = filename;
        this.fileurl = fileurl;
    }
}
