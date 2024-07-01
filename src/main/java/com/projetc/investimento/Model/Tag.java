package com.projetc.investimento.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "tb_ticket")
@Entity
@Getter @Setter @NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idTicket;

    @Column(name = "name")
    private String name;

    @Column(name = "tagName")
    private String tagName;

    @Column(name = "valorAtual")
    private Double valorAtual;

    @Column(name = "logo")
    private String logo;

    @Column(name = "data_atualizacao")
    private String date;

}
