package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class ToDo {

    private final UUID uuid;
    private final String title;
    private final String text;

    public ToDo(@JsonProperty UUID uuid,
                @JsonProperty String title,
                @JsonProperty String text) {
        this.uuid = uuid;
        this.title = title;
        this.text = text;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
