package com.professions.okana.kn.model;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

@Table(name = "users")
@Entity
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "encrypted_password", nullable = false, length = 45)
    private String encryptedPassword;

    @Column(name = "creared_at", nullable = false)
    private Instant crearedAt;

    public Instant getCrearedAt() {
        return crearedAt;
    }

    public void setCrearedAt(LocalDate crearedAt) {
        this.crearedAt = crearedAt;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @ManyToMany(targetEntity = Profession.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "profession_has_users",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "profession_id"))
    private Set<Profession> author;
}