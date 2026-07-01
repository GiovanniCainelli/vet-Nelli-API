package com.vetnelliFront.vetnelliFront.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;


@AllArgsConstructor
@Getter
@Builder
public class LoginResponse {
    private String token;// token
}
