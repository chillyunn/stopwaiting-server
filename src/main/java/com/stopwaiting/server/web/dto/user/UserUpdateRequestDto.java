package com.stopwaiting.server.web.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String phoneNumber;
    private String token;
    private Integer reported;

    @Builder

    public UserUpdateRequestDto(String phoneNumber, String token, Integer reported) {
        this.phoneNumber = phoneNumber;
        this.token = token;
        this.reported = reported;
    }
}
