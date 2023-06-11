package io.mkolodziejczyk92.eventplannerapp.data.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StartingTime {
    AM_9("9 am"),
    AM_11("11 am"),
    PM_3("3 pm"),
    PM_5("5 pm");

    private String wordForm;

    StartingTime(String s) {
        this.wordForm = s;
    }

    @JsonValue
    public String getWordForm() {
        return wordForm;
    }
}
