package com.projetc.investimento.Enum;

import lombok.Getter;

@Getter
public enum MessagesEnum {

    TAG_NOT_FOUND("Tag não encontrada."),
    TAG_EXISTS("Tag já cadastrada.");

    private String descricao;

    MessagesEnum(String descricao){this.descricao = descricao;}
}
