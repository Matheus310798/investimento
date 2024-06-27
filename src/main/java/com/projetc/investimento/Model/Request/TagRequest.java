package com.projetc.investimento.Model.Request;

import com.projetc.investimento.Model.DTO.TagDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TagRequest {

    private List<TagDTO> results;

}
