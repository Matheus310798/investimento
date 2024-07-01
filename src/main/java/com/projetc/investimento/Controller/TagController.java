package com.projetc.investimento.Controller;

import com.projetc.investimento.Model.Request.TagRequest;
import com.projetc.investimento.Model.Response.TagResponse;
import com.projetc.investimento.Model.Tag;
import com.projetc.investimento.Service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping(value = "/salvar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Tag saveTag(@RequestBody TagRequest data) {return tagService.saveTag(data);}

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/buscarTag/{tag}/{update}")
    @ResponseStatus(HttpStatus.OK)
    public TagResponse findTag(@PathVariable("tag") Long id,
                               @PathVariable("update") Boolean update){
        return tagService.findTag(id, update);}

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(value = "deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTag(@PathVariable("id") Long id){ tagService.deleteTag(id);}
}
