package com.example.CodeSharingPlatform.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "codes")
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "code", columnDefinition = "LONGVARCHAR")
    private String code;

    @Column(name = "POSTED_AT", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    public Code() {
        this.dateTime = LocalDateTime.now().withNano(0);
    }

    public Code(String code) {
        this();
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
