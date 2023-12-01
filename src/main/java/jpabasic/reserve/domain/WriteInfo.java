package jpabasic.reserve.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class WriteInfo {
    
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

    public WriteInfo() {
    }

    public WriteInfo(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void updateModifyDate() {
        this.modifyDate = LocalDateTime.now();
    }
}
