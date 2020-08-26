package it.nike.gestnike.models.auth;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private ERole name;

    public Role() {
    }
    public Role(ERole role) {
        this.name = role;
    }
}