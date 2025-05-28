package br.com.uj.livrariaapi.model.services;

import br.com.uj.livrariaapi.model.configuration.PasswordHash;
import br.com.uj.livrariaapi.model.dtos.EnderecoDTO;
import br.com.uj.livrariaapi.model.dtos.UsuarioDTO;
import br.com.uj.livrariaapi.model.entities.EnderecoModel;
import br.com.uj.livrariaapi.model.entities.UsuarioModel;
import br.com.uj.livrariaapi.model.repositories.EnderecoRepository;
import br.com.uj.livrariaapi.model.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    //cadastrar usuario com endereço
    @Transactional
    public UsuarioModel cadastroUsuario(UsuarioDTO usuarioDTO){

        var usuario = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDTO, usuario);

        String senha = PasswordHash.encoder(usuarioDTO.senha());
        usuario.setSenha(senha);
        UsuarioModel novoUsuario = usuarioRepository.save(usuario);

        if (usuarioDTO.endereco() != null){
            @Valid @NotBlank EnderecoDTO enderecoDTO = usuarioDTO.endereco();

            var endereco = new EnderecoModel();
            BeanUtils.copyProperties(enderecoDTO, endereco);
            endereco.setUsuario(novoUsuario);
            enderecoRepository.save(endereco);
        }
        return novoUsuario;
    }
}
