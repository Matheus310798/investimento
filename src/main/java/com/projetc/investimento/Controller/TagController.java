package com.projetc.investimento.Controller;

import com.projetc.investimento.Model.Request.TagRequest;
import com.projetc.investimento.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/{tag}", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public TagRequest findTag(@PathVariable("tag") String tag) {return tagService.findTag(tag);}

}
