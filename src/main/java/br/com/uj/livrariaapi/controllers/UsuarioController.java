package br.com.uj.livrariaapi.controllers;

import br.com.uj.livrariaapi.model.dtos.CadastrarUsuarioDTO;
import br.com.uj.livrariaapi.model.dtos.LogarUsuarioDTO;
import br.com.uj.livrariaapi.model.dtos.LoginResponseDTO;
import br.com.uj.livrariaapi.model.entities.UsuarioModel;
import br.com.uj.livrariaapi.model.repositories.UsuarioRepository;
import br.com.uj.livrariaapi.model.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<Map<String, Object>> cadastrar(@RequestBody @Valid CadastrarUsuarioDTO cadastrarUsuarioDTO){

        UsuarioModel criarUsuario = usuarioService.cadastroUsuario(cadastrarUsuarioDTO);
        Map<String, Object> resultado = new HashMap<>();
        resultado.put("usuario", criarUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @PostMapping("/logar")
    public ResponseEntity<Object> login (@RequestBody @Valid LogarUsuarioDTO logarUsuarioDTO){
        Optional<UsuarioModel> procurarUsuario = usuarioService.logarUsuario(logarUsuarioDTO);

        if (procurarUsuario.isPresent()){
            UsuarioModel usuario = procurarUsuario.get();
            LoginResponseDTO responseDTO = new LoginResponseDTO("Sucesso", usuario.getId());
            return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ou senha inválido!");
        }
    }


}
