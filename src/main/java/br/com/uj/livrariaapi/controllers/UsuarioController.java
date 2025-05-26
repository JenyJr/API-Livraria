package br.com.uj.livrariaapi.controllers;

import br.com.uj.livrariaapi.model.dtos.UsuarioDTO;
import br.com.uj.livrariaapi.model.entities.EnderecoModel;
import br.com.uj.livrariaapi.model.entities.UsuarioModel;
import br.com.uj.livrariaapi.model.repositories.EnderecoRepository;
import br.com.uj.livrariaapi.model.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody @Valid UsuarioDTO usuarioDTO){

        var usuario = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDTO, usuario);

        var endereco = new EnderecoModel();
        endereco.setRua(usuarioDTO.enderecoDTO().rua());
        endereco.setNumero(usuarioDTO.enderecoDTO().numero());
        endereco.setComplemento(usuarioDTO.enderecoDTO().complemento());
        endereco.setBairro(usuarioDTO.enderecoDTO().bairro());
        endereco.setCidade(usuarioDTO.enderecoDTO().cidade());
        endereco.setEstado(usuarioDTO.enderecoDTO().estado());
        endereco.setCep(usuarioDTO.enderecoDTO().cepModel());

        EnderecoRepository enderecoTemporario = null;
        enderecoTemporario.save(endereco);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @GetMapping("/teste")
    public Iterable<UsuarioModel> obterNomes(){
         return usuarioRepository.findAll();
    }
}
