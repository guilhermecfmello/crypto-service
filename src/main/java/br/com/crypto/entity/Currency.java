package br.com.crypto.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String name;

    private String code;

    @Column(name="createdat")
    private String createdAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}

//    name VARCHAR(45),
//    code VARCHAR(45),
//    createdAt TIMESTAMP