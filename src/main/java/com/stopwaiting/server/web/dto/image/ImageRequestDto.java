package com.stopwaiting.server.web.dto.image;

import com.stopwaiting.server.domain.image.WaitingInfoImage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;

@Getter
@NoArgsConstructor
public class ImageRequestDto {
    private String filename;
    private String fileurl;

    @Builder
    public ImageRequestDto(String filename, String fileurl) {
        this.filename = filename;
        this.fileurl = fileurl;
    }

    public WaitingInfoImage toEntity(){
        return WaitingInfoImage.builder()
                .filename(filename)
                .fileurl(fileurl)
                .build();
    }
}
