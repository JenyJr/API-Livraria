package br.com.uj.livrariaapi.model.services;

import br.com.uj.livrariaapi.model.configuration.PasswordHash;
import br.com.uj.livrariaapi.model.dtos.EnderecoDTO;
import br.com.uj.livrariaapi.model.dtos.CadastrarUsuarioDTO;
import br.com.uj.livrariaapi.model.dtos.LogarUsuarioDTO;
import br.com.uj.livrariaapi.model.entities.EnderecoModel;
import br.com.uj.livrariaapi.model.entities.UsuarioModel;
import br.com.uj.livrariaapi.model.repositories.EnderecoRepository;
import br.com.uj.livrariaapi.model.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    //cadastrar usuario com endereço
    @Transactional
    public UsuarioModel cadastroUsuario(CadastrarUsuarioDTO cadastrarUsuarioDTO){

        var usuario = new UsuarioModel();
        BeanUtils.copyProperties(cadastrarUsuarioDTO, usuario);

        String senha = PasswordHash.encoder(cadastrarUsuarioDTO.senha());
        usuario.setSenha(senha);
        UsuarioModel novoUsuario = usuarioRepository.save(usuario);

        if (cadastrarUsuarioDTO.endereco() != null){
            @Valid @NotBlank EnderecoDTO enderecoDTO = cadastrarUsuarioDTO.endereco();

            var endereco = new EnderecoModel();
            BeanUtils.copyProperties(enderecoDTO, endereco);
            endereco.setUsuario(novoUsuario);
            enderecoRepository.save(endereco);
        }
        return novoUsuario;
    }

    public Optional<UsuarioModel> logarUsuario(LogarUsuarioDTO logarUsuarioDTO){
        UsuarioModel usuario = new UsuarioModel();
        BeanUtils.copyProperties(logarUsuarioDTO, usuario);

        String senha = usuario.getSenha();
        PasswordHash.encoder(senha);

        return usuarioRepository.findById(usuario.getId());
    }

}
