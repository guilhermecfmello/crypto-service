package br.com.crypto.repository.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "currency")
@RequiredArgsConstructor
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private UUID id;

    private String name;

    private String code;

    @Column(name="createdat", insertable = false, updatable = false)
    private String createdAt;

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Currency(String name, String code) {
        this.name = name;
        this.code = code;
    }

}
