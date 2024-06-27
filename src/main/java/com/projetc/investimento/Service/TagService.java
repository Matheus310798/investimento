package com.projetc.investimento.Service;

import com.projetc.investimento.Gateway.BrapiGateway;
import com.projetc.investimento.Model.Request.TagRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    @Autowired
    BrapiGateway brapiGateway;

    public TagRequest findTag(String tag){
        ResponseEntity<TagRequest> resp = brapiGateway.findTag(tag);
        return resp.getBody();
    }
}
