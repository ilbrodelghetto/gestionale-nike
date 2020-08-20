package it.nike.gestnike.models.auth;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ruolo")
public enum ERole {

    ADMIN, USER;
}
