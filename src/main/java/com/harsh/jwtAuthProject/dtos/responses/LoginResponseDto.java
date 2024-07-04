package com.harsh.jwtAuthProject.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {
    private String token;
    private long ExpireIn;
}
