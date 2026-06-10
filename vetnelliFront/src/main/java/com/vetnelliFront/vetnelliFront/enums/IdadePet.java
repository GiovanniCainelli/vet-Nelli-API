package com.vetnelliFront.vetnelliFront.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum IdadePet {
    FILHOTE,
    ADULTO,
    IDOSO;

    @JsonCreator
    public static IdadePet fromString(String idadePet) {
        return IdadePet.valueOf(idadePet.toUpperCase());
    }

}
