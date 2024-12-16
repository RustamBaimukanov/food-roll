package com.own.foodservice;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class BaseEntity {

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }

}

