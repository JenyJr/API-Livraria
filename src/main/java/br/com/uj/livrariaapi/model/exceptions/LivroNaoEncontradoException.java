package br.com.uj.livrariaapi.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LivroNaoEncontradoException extends RuntimeException{

    public LivroNaoEncontradoException(int id){
        super("ID: " + id + "não localizado.");
    }
}
