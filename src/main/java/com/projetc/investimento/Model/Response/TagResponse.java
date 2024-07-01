package com.projetc.investimento.Model.Response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TagResponse {
    private String name;
    private String tagName;
    private String logo;
    private Double valorAtual;
    private String date;

    public TagResponse(String name, String tagName, String logo, Double valorAtual, String date){
        this.name = name;
        this.tagName = tagName;
        this.logo = logo;
        this.valorAtual = valorAtual;
        this.date = date;
    }

}
