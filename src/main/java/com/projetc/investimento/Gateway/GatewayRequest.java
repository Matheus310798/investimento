package com.projetc.investimento.Gateway;

import com.projetc.investimento.Model.DTO.TagDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GatewayRequest {

    private List<TagDTO> results;

}
