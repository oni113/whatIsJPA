package jpabasic.reserve.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    private String email;
    
    private String name;

    @Embedded
    private WriteInfo writeInfo;

    protected User() {
    }

    public User(String email, String name, WriteInfo writeInfo) {
        this.email = email;
        this.name = name;
        this.writeInfo = writeInfo;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public WriteInfo getWriteInfo() {
        return this.writeInfo;
    }

    public LocalDateTime getCreateDate() {
        return writeInfo.getCreateDate();
    }

    public LocalDateTime getModifyDate() {
        return writeInfo.getModifyDate();
    }

    public void changeName(String newName) {
        this.name = newName;
    }

    public void updateModifyDate() {
        this.writeInfo.updateModifyDate();
    }
}