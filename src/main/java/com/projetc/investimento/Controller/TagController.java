package com.projetc.investimento.Controller;

import com.projetc.investimento.Model.Request.TagRequest;
import com.projetc.investimento.Model.Response.TagResponse;
import com.projetc.investimento.Model.Tag;
import com.projetc.investimento.Service.TagService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/tag")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @Operation(description = "Salva a Ação ou Fii")
    @PostMapping(value = "/salvar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Tag saveTag(@RequestBody TagRequest data) {return tagService.saveTag(data);}

    @Operation(description = "Busca a tag pelo id")
    @GetMapping(value = "/buscarTag/{idTag}/{update}")
    @ResponseStatus(HttpStatus.OK)
    public TagResponse findTag(@PathVariable("idTag") Long id,
                               @PathVariable("update") Boolean update){
        return tagService.findTag(id, update);}

    @Operation(description = "Deleta a tag pelo id")
    @DeleteMapping(value = "deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTag(@PathVariable("id") Long id){ tagService.deleteTag(id);}

}
