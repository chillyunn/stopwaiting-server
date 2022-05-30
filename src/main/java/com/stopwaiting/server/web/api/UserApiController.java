package com.stopwaiting.server.web.api;

import com.stopwaiting.server.service.user.UserService;
import com.stopwaiting.server.web.dto.user.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    @PostMapping("/api/v1/checkid")
    public Long checkId(@RequestBody UserCheckIdRequestDto userCheckIdRequestDto){
        return userService.checkId(userCheckIdRequestDto.getId());
    }
    @PostMapping("/api/v1/signup")
    public Long save(@RequestBody UserSaveRequestDto requestDto) {
        return userService.save(requestDto);
    }

    @PostMapping("/api/v1/login")
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto requestDto){
        return userService.login(requestDto);
    }
    @PutMapping("/api/v1/user/{id}")
    public Long update(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto){
        return userService.update(id,requestDto);
    }
    @PutMapping("/api/v1/user/report/{id}")
    public Long addReport(@PathVariable Long id){
        return userService.addReport(id);
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
