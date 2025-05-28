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
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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

        //TODO arrumar o body do endereço
        if (cadastrarUsuarioDTO.endereco() != null){
            @Valid @NotBlank EnderecoDTO enderecoDTO = cadastrarUsuarioDTO.endereco();

            var endereco = new EnderecoModel();
            BeanUtils.copyProperties(enderecoDTO, endereco);
            endereco.setUsuario(novoUsuario);
            enderecoRepository.save(endereco);
        }
        return novoUsuario;
    }

    public Optional<UsuarioModel> logarUsuario(LogarUsuarioDTO logarUsuarioDTO) {

        try {
            Optional<UsuarioModel> usuarioEmail = usuarioRepository.findByEmail(logarUsuarioDTO.email());
            if (usuarioEmail.isPresent()) {
                UsuarioModel usuarioBD = usuarioEmail.get();

                if (PasswordHash.matches(logarUsuarioDTO.senha(), usuarioBD.getSenha())) {
                    System.out.println("Email: " + usuarioBD.getEmail());
                    System.out.println("Nome: " + usuarioBD.getNome());
                    return usuarioEmail;
                } else {
                    System.out.println("Senha inválida!");
                    return Optional.empty();
                }
            }else{
                System.out.println("Email não encontrado!");
                return Optional.empty();
            }
        } catch (BeansException e) {
            System.out.println("Erro de Login!!" + e.getMessage());
            throw new RuntimeException("Erro ao logar!!" + e);
        }

    }
}
