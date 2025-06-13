package br.com.uj.livrariaapi.model.repositories;

import br.com.uj.livrariaapi.model.entities.DownloadModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DownloadRepository extends JpaRepository<DownloadModel, Integer> {
}
