package br.com.uj.livrariaapi.controllers;

import br.com.uj.livrariaapi.model.configuration.PasswordHash;
import br.com.uj.livrariaapi.model.dtos.EnderecoDTO;
import br.com.uj.livrariaapi.model.dtos.UsuarioDTO;
import br.com.uj.livrariaapi.model.entities.EnderecoModel;
import br.com.uj.livrariaapi.model.entities.UsuarioModel;
import br.com.uj.livrariaapi.model.repositories.EnderecoRepository;
import br.com.uj.livrariaapi.model.repositories.UsuarioRepository;
import br.com.uj.livrariaapi.model.services.UsuarioService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Map<String, Object>> cadastrar(@RequestBody @Valid UsuarioDTO usuarioDTO){

        UsuarioModel criarUsuario = usuarioService.cadastroUsuario(usuarioDTO);
        Map<String, Object> resultado = new HashMap<>();
        resultado.put("usuario", criarUsuario);


        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }


}
