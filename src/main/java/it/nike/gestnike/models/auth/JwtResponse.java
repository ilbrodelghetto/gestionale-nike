package it.nike.gestnike.models.auth;

import lombok.Data;

import java.util.List;
@Data
public class JwtResponse {

    private String jwt;

    private String id;

    private String username;

    private String email;

    private List<String> roles;

    public JwtResponse(String jwt, String id, String username, String email, List<String> roles) {
        this.jwt = jwt;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
