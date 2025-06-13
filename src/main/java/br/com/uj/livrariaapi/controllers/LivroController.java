package br.com.uj.livrariaapi.controllers;

import br.com.uj.livrariaapi.model.dtos.BaixarLivroDTO;
import br.com.uj.livrariaapi.model.dtos.CadastrarLivroDTO;
import br.com.uj.livrariaapi.model.dtos.ListarLivrosDTO;
import br.com.uj.livrariaapi.model.dtos.LivroDownloadDTO;
import br.com.uj.livrariaapi.model.entities.LivroModel;
import br.com.uj.livrariaapi.model.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/listar")
    public ResponseEntity<Iterable<ListarLivrosDTO>> listarLivros(){
        Iterable<ListarLivrosDTO> livrosDTO = livroService.listagemLivros();
        return ResponseEntity.ok(livrosDTO);
    }

    @Transactional
    @GetMapping("/download/{idLivro}")
    public ResponseEntity<LivroDownloadDTO> baixarLivro(
            @PathVariable("idLivro") Integer idLivro,
            @RequestParam("idUsuario") Integer idUsuario
    ){
        BaixarLivroDTO baixarLivroDTO = new BaixarLivroDTO(idLivro, idUsuario);
        LivroDownloadDTO livroDetalhe = livroService.baixarLivroComFuncao(baixarLivroDTO);
        return ResponseEntity.ok(livroDetalhe);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<LivroModel> cadastrarLivro(@RequestBody CadastrarLivroDTO cadastrarLivroDTO) {
        LivroModel salvarLivro = new LivroModel();
        salvarLivro.setDescricao(cadastrarLivroDTO.descricao());
        salvarLivro.setUrl_imagem(cadastrarLivroDTO.url_imagem());
        salvarLivro.setLink_Livro(cadastrarLivroDTO.link_Livro());
        salvarLivro.setTitulo(cadastrarLivroDTO.titulo());
        salvarLivro.setPaginas(cadastrarLivroDTO.paginas());

        LivroModel novoLivro = new LivroModel();
        return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);
    }
}