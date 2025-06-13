package br.com.uj.livrariaapi.controllers;

import br.com.uj.livrariaapi.model.dtos.CadastrarEditoraDTO; // DTO de entrada
import br.com.uj.livrariaapi.model.entities.EditoraModel;
import br.com.uj.livrariaapi.model.repositories.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/editora")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<CadastrarEditoraDTO> cadastrarEditora(@RequestBody CadastrarEditoraDTO cadastrarEditoraDTO) {

        EditoraModel salvarEditora = new EditoraModel();
        salvarEditora.setEditora(cadastrarEditoraDTO.editora());

        EditoraModel novaEditora = editoraRepository.save(salvarEditora);
        CadastrarEditoraDTO response = new CadastrarEditoraDTO("Sucesso", novaEditora.getEditora());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}