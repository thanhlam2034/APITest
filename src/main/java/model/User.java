package model;

import lombok.*;

@Data
@Builder
/**
 * @Author lam.nguyen
 */
public class User {
    private String username;
    private String password;
    private String token;
}
