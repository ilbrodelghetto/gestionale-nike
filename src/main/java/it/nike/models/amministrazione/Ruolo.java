package it.nike.models.amministrazione;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ruolo")
public enum Ruolo {

    ADMIN, USER;
}
