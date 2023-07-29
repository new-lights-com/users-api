package com.lights.users.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserToken {
    private String username;
    private String displayName;
    private String email;
    private String imageOriginal;
}

