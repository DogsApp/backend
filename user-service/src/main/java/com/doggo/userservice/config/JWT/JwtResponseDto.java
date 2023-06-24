package com.doggo.userservice.config.JWT;

import lombok.Builder;

@Builder
public record JwtResponseDto( String username,
                              String token) {
}
