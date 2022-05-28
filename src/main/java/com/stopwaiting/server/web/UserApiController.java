package com.stopwaiting.server.web.dto.user;

import com.stopwaiting.server.service.user.UserService;
import com.stopwaiting.server.web.dto.user.UserLoginRequestDto;
import com.stopwaiting.server.web.dto.user.UserLoginResponseDto;
import com.stopwaiting.server.web.dto.user.UserResponseDto;
import com.stopwaiting.server.web.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

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
