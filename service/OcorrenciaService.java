package br.pa.gov.ssp.bombeiros.siscob.service;

import br.pa.gov.ssp.bombeiros.siscob.service.dto.OcorrenciaDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link br.pa.gov.ssp.bombeiros.siscob.domain.Ocorrencia}.
 */
public interface OcorrenciaService {

    /**
     * Save a ocorrencia.
     *
     * @param ocorrenciaDTO the entity to save.
     * @return the persisted entity.
     */
    OcorrenciaDTO save(OcorrenciaDTO ocorrenciaDTO);

    /**
     * Get all the ocorrencias.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<OcorrenciaDTO> findAll(Pageable pageable);


    /**
     * Get the "id" ocorrencia.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<OcorrenciaDTO> findOne(Long id);

    /**
     * Delete the "id" ocorrencia.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
