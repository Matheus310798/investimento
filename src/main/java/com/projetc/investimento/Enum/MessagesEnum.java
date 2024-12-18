package com.projetc.investimento.Enum;

import lombok.Getter;

@Getter
public enum MessagesEnum {

    TAG_NOT_FOUND("Tag não encontrada. Informe outra."),
    TAG_EXISTS("Tag existente.");

    private String descricao;

    MessagesEnum(String descricao){this.descricao = descricao;}
}
