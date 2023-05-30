package model;

import lombok.*;

@Data
@Builder
public class User {
    private String username;
    private String password;
    private String token;
}
