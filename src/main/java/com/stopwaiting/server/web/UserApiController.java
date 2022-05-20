package com.stopwaiting.server.web;

import com.stopwaiting.server.service.user.UserService;
import com.stopwaiting.server.web.dto.UserResponseDto;
import com.stopwaiting.server.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @PostMapping("/api/v1/user")
    public Long save(@RequestBody UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }

    @GetMapping("/api/v1/user/{id}")
    public UserResponseDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/api/v1/user/{id}")
    public Long delete(@PathVariable Long id){
        userService.delete(id);
        return id;
    }
}
