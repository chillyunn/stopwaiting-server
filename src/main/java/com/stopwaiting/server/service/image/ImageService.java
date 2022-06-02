package com.stopwaiting.server.service.image;

import com.stopwaiting.server.domain.image.WaitingInfoImageRepository;
import com.stopwaiting.server.web.dto.image.ImageRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class ImageService {
    private final WaitingInfoImageRepository imageRepository;

    @Transactional
    public Long save(MultipartFile file) throws IOException {
            //Date date= new Date();
            String originalFilename = file.getOriginalFilename();
            File dest = new File("C:/KIT/2022-1/Capstone/image" + originalFilename);
            file.transferTo(dest);

            ImageRequestDto ImageRequestDto = new ImageRequestDto(originalFilename, "C:/KIT/2022-1/Capstone/image" + originalFilename);
            return imageRepository.save(ImageRequestDto.toEntity()).getId();
    }

}
