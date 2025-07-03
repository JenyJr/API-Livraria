package br.com.uj.livrariaapi.model.services;

import br.com.uj.livrariaapi.model.dtos.BaixarLivroDTO;
import br.com.uj.livrariaapi.model.dtos.LivroDownloadDTO;
import br.com.uj.livrariaapi.model.dtos.ListarLivrosDTO;

import br.com.uj.livrariaapi.model.dtos.LivroProjetado;
import br.com.uj.livrariaapi.model.entities.ListaLivroModel;
import br.com.uj.livrariaapi.model.entities.LivroModel;
import br.com.uj.livrariaapi.model.repositories.ListaLivroRepository;
import br.com.uj.livrariaapi.model.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private ListaLivroRepository listaLivroRepository;

    @Transactional
    public LivroModel salvarLivro(LivroModel livro) {
        return livroRepository.save(livro);
    }

    @Transactional(readOnly = true)
    public Iterable<ListarLivrosDTO> listagemLivros (){
        List<LivroProjetado> livroProcurado = listaLivroRepository.procurarLivros();

        return livroProcurado.stream()
                .map(livProcurado -> new ListarLivrosDTO(
                        livProcurado.getIdLivro(),
                        livProcurado.getTitulo(),
                        livProcurado.getDescricao(),
                        livProcurado.getUrlImagem(),
                        livProcurado.getLinkLivro(),
                        livProcurado.getPaginas(),
                        livProcurado.getNomeAutor(),
                        livProcurado.getCategoria()
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public LivroDownloadDTO baixarLivroComFuncao(BaixarLivroDTO baixarLivroDTO){
        String urlDownload = livroRepository.chamarBuscarDownloadLivro(
                baixarLivroDTO.idLivro()
        );

        if (urlDownload != null && !urlDownload.isEmpty()) {
            return new LivroDownloadDTO(urlDownload);
        } else {
            throw new RuntimeException("Não foi possível processar o download ou livro não encontrado.");
        }
    }


}