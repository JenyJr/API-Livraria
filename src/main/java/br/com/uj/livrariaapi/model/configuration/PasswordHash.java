package br.com.uj.livrariaapi.model.configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHash {

    private static final BCryptPasswordEncoder encoderSenha = new BCryptPasswordEncoder();

    //Metodo para criptografar as senha no BD
    public static String encoder(String senha){
        return encoderSenha.encode(senha);
    }

    public static boolean matches(String noHash, String hash){
        return encoderSenha.matches(noHash, hash);
    }
}
