package br.com.uj.livrariaapi.controllers;// No AutorController.java
import br.com.uj.livrariaapi.model.dtos.CadastrarAutorDTO;
import br.com.uj.livrariaapi.model.entities.AutorModel;
import br.com.uj.livrariaapi.model.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<CadastrarAutorDTO> cadastrarAutor(@RequestBody CadastrarAutorDTO cadastrarAutorDTO) {
        AutorModel salvarCadastro = new AutorModel();
        salvarCadastro.setNome(cadastrarAutorDTO.nome());

        AutorModel novoAutor = autorRepository.save(salvarCadastro);

        CadastrarAutorDTO responseCadastro = new CadastrarAutorDTO("Sucesso", novoAutor.getNome());
        return new ResponseEntity<>(responseCadastro, HttpStatus.CREATED);
    }
}