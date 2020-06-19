package br.pa.gov.ssp.bombeiros.siscob.service.impl;

import br.pa.gov.ssp.bombeiros.siscob.service.OcorrenciaService;
import br.pa.gov.ssp.bombeiros.siscob.domain.Ocorrencia;
import br.pa.gov.ssp.bombeiros.siscob.repository.OcorrenciaRepository;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.OcorrenciaDTO;
import br.pa.gov.ssp.bombeiros.siscob.service.mapper.OcorrenciaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Ocorrencia}.
 */
@Service
@Transactional
public class OcorrenciaServiceImpl implements OcorrenciaService {

    private final Logger log = LoggerFactory.getLogger(OcorrenciaServiceImpl.class);

    private final OcorrenciaRepository ocorrenciaRepository;

    private final OcorrenciaMapper ocorrenciaMapper;

    public OcorrenciaServiceImpl(OcorrenciaRepository ocorrenciaRepository, OcorrenciaMapper ocorrenciaMapper) {
        this.ocorrenciaRepository = ocorrenciaRepository;
        this.ocorrenciaMapper = ocorrenciaMapper;
    }

    /**
     * Save a ocorrencia.
     *
     * @param ocorrenciaDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public OcorrenciaDTO save(OcorrenciaDTO ocorrenciaDTO) {
        log.debug("Request to save Ocorrencia : {}", ocorrenciaDTO);
        Ocorrencia ocorrencia = ocorrenciaMapper.toEntity(ocorrenciaDTO);
        ocorrencia = ocorrenciaRepository.save(ocorrencia);
        return ocorrenciaMapper.toDto(ocorrencia);
    }

    /**
     * Get all the ocorrencias.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<OcorrenciaDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Ocorrencias");
        return ocorrenciaRepository.findAll(pageable)
            .map(ocorrenciaMapper::toDto);
    }


    /**
     * Get one ocorrencia by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<OcorrenciaDTO> findOne(Long id) {
        log.debug("Request to get Ocorrencia : {}", id);
        return ocorrenciaRepository.findById(id)
            .map(ocorrenciaMapper::toDto);
    }

    /**
     * Delete the ocorrencia by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Ocorrencia : {}", id);
        ocorrenciaRepository.deleteById(id);
    }
}
