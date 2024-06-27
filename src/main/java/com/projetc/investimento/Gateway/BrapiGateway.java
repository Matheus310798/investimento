package com.projetc.investimento.Gateway;

import com.projetc.investimento.Exception.DefaultException;
import com.projetc.investimento.Exception.TagNotFoundException;
import com.projetc.investimento.Model.Request.TagRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class BrapiGateway {

    private static final String apiExterna = "https://brapi.dev/api/quote/";
    private static final String token = "xBiducmQEgtDH1LQPkG1dU";


    public ResponseEntity<TagRequest> findTag(String tag){
        String url = apiExterna + tag;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TagRequest> resp;

        try {
            resp = restTemplate.exchange(url, HttpMethod.GET, getHttp(), TagRequest.class);
        } catch (HttpClientErrorException e){
            throw new DefaultException(e.getMessage(), HttpStatus.valueOf(e.getStatusCode().value()));
        }
        if(resp.getBody().getResults().get(0).getShortName() == null){
            throw new TagNotFoundException("Tag Not Found");
        }
        return resp;
    }

    private HttpEntity<String> getHttp(){
        HttpHeaders headers = httpHeaders(token);
        final HttpEntity<String> entity = new HttpEntity<>(headers);
        return entity;
    }
    private HttpHeaders httpHeaders(String token){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        return headers;
    }
}
