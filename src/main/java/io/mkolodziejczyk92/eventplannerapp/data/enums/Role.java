package io.mkolodziejczyk92.eventplannerapp.data.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Role {

    ADMIN("ADMIN"),
    USER("USER");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue(){
        return value;
    }

}
