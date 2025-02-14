package br.com.pinguins.tcc.backend.controllers;

import br.com.pinguins.tcc.backend.dtos.RemedioDTO;
import br.com.pinguins.tcc.backend.dtos.UsuarioDTO;
import br.com.pinguins.tcc.backend.entities.Remedio;
import br.com.pinguins.tcc.backend.services.RemedioService;
import br.com.pinguins.tcc.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/remedios")
public class RemedioController {

    @Autowired
    private RemedioService remedioService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RemedioDTO>> findAll() {
        return ResponseEntity.ok(remedioService.findAll());
    }

    @GetMapping(value = "/id/{nome}")
    public ResponseEntity<List<RemedioDTO>> findByNome(@PathVariable("nome") String nome) {
        List<RemedioDTO> remedioDTO = remedioService.findByNome(nome);

        return ResponseEntity.ok(remedioDTO);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RemedioDTO> save(@RequestBody RemedioDTO remedioDTO) {
        remedioService.save(remedioDTO);

        return ResponseEntity.ok(remedioDTO);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RemedioDTO> update(@PathVariable("id") Integer id, @RequestBody RemedioDTO remedio) {
        RemedioDTO remedioDTO = remedioService.updateById(id, remedio);

        return ResponseEntity.ok().body(remedioDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
        remedioService.deleteById(id);

        return ResponseEntity.ok("Apagado com sucesso!");
    }
}
