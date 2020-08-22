package it.nike.gestnike.models.auth;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "roles")
@Data
public class Role {
    @Id
    private String id;

    private ERole name;

    public Role() {
    }
    public Role(ERole role) {
        this.name = role;
    }
}