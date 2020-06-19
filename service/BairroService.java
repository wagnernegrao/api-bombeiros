package br.pa.gov.ssp.bombeiros.siscob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import br.pa.gov.ssp.bombeiros.siscob.domain.Bairro;
import br.pa.gov.ssp.bombeiros.siscob.repository.filter.BairroFilter;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.BairroDTO;

/**
 * Service Interface for managing
 * {@link br.pa.gov.ssp.bombeiros.siscob.domain.Bairro}.
 */
public interface BairroService {

    /**
     * Save a bairro.
     *
     * @param bairroDTO the entity to save.
     * @return the persisted entity.
     */
    BairroDTO save(BairroDTO bairroDTO);

    /**
     * Get all the bairros.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BairroDTO> findAll(Pageable pageable);

    /**
     * Get the "id" bairro.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BairroDTO> findOne(Long id);

    List<Bairro> findByCidadeId(BairroFilter bairroFilter);

    /****
     * 
     * @param id
     * @return
     */

    List<Bairro> findAllByNome(String nome);

    List<Bairro> findAllByCidadeId(Long id);

    List<Bairro> findAllByCidadeNome(String nome);

}
