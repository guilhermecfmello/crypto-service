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

    @Column(name="createdat", insertable = false, updatable = false)
    private String createdAt;

    public Currency(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Currency() {

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

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
