package it.nike.gestnike.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ruolo")
public enum Ruolo {

    ADMIN, USER;
}
