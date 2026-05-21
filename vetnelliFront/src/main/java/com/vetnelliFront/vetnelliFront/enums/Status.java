package com.vetnelliFront.vetnelliFront.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Status {
    AGENDADA,
    EM_ATENDIMENTO,
    FINALIZADA;

    @JsonCreator
    public static Status fromString(String status){
        return Status.valueOf(status.toUpperCase());
    }
}
