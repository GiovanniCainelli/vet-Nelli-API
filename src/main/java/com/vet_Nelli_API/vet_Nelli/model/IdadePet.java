package com.vet_Nelli_API.vet_Nelli.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum IdadePet {
    FILHOTE,
    ADULTO,
    IDOSO;

    @JsonCreator
    public static IdadePet fromString(String value) {
        return IdadePet.valueOf(value.toUpperCase());
    }
}