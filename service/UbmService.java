package br.pa.gov.ssp.bombeiros.siscob.service;

import br.pa.gov.ssp.bombeiros.siscob.service.dto.UbmDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link br.pa.gov.ssp.bombeiros.siscob.domain.Ubm}.
 */
public interface UbmService {

    /**
     * Save a ubm.
     *
     * @param ubmDTO the entity to save.
     * @return the persisted entity.
     */
    UbmDTO save(UbmDTO ubmDTO);

    /**
     * Get all the ubms.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<UbmDTO> findAll(Pageable pageable);


    /**
     * Get the "id" ubm.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UbmDTO> findOne(Long id);

    /**
     * Delete the "id" ubm.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
