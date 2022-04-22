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

    public Currency(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
