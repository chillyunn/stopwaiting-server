package com.stopwaiting.server.web.api;

import com.stopwaiting.server.service.image.ImageService;
import com.stopwaiting.server.web.dto.image.ImageRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class ImageApiController {
    private final ImageService imageService;
    @PostMapping("/api/v1/waitinginfo/image")
    public Long saveImage(MultipartFile file) throws IOException {
        return imageService.save(file);
    }
    @PostMapping("/api/v1/waitinginfo/images")
    public void saveImages(MultipartFile[] files) {
        Arrays.asList(files)
                .stream()
                .map(file-> {
                    try {
                        return saveImage(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }
}
