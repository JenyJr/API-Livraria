package br.com.uj.livrariaapi.controllers;

import br.com.uj.livrariaapi.model.dtos.EnderecoDTO;
import br.com.uj.livrariaapi.model.dtos.UsuarioDTO;
import br.com.uj.livrariaapi.model.entities.EnderecoModel;
import br.com.uj.livrariaapi.model.entities.UsuarioModel;
import br.com.uj.livrariaapi.model.repositories.EnderecoRepository;
import br.com.uj.livrariaapi.model.repositories.UsuarioRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody @Valid UsuarioDTO usuarioDTO){

        var usuario = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        UsuarioModel novoUsuario = usuarioRepository.save(usuario);

        EnderecoModel guardarEndereco = null;
        if (usuarioDTO.endereco() != null){
            @Valid @NotBlank EnderecoDTO enderecoDTO = usuarioDTO.endereco();

            var endereco = new EnderecoModel();
            BeanUtils.copyProperties(enderecoDTO, endereco);
            endereco.setUsuario(novoUsuario);
            guardarEndereco = enderecoRepository.save(endereco);
        }

        Map<String, Object> resultado= new HashMap<>();
        resultado.put("usuario", novoUsuario);
        resultado.put("endereço", guardarEndereco);

        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @GetMapping("/teste")
    public Iterable<UsuarioModel> obterNomes(){
         return usuarioRepository.findAll();
    }
}
