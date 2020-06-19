package br.pa.gov.ssp.bombeiros.siscob.service.impl;

import br.pa.gov.ssp.bombeiros.siscob.service.UbmService;
import br.pa.gov.ssp.bombeiros.siscob.domain.Ubm;
import br.pa.gov.ssp.bombeiros.siscob.repository.UbmRepository;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.UbmDTO;
import br.pa.gov.ssp.bombeiros.siscob.service.mapper.UbmMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Ubm}.
 */
@Service
@Transactional
public class UbmServiceImpl implements UbmService {

    private final Logger log = LoggerFactory.getLogger(UbmServiceImpl.class);

    private final UbmRepository ubmRepository;

    private final UbmMapper ubmMapper;

    public UbmServiceImpl(UbmRepository ubmRepository, UbmMapper ubmMapper) {
        this.ubmRepository = ubmRepository;
        this.ubmMapper = ubmMapper;
    }

    /**
     * Save a ubm.
     *
     * @param ubmDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public UbmDTO save(UbmDTO ubmDTO) {
        log.debug("Request to save Ubm : {}", ubmDTO);
        Ubm ubm = ubmMapper.toEntity(ubmDTO);
        ubm = ubmRepository.save(ubm);
        return ubmMapper.toDto(ubm);
    }

    /**
     * Get all the ubms.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<UbmDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Ubms");
        return ubmRepository.findAll(pageable)
            .map(ubmMapper::toDto);
    }


    /**
     * Get one ubm by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<UbmDTO> findOne(Long id) {
        log.debug("Request to get Ubm : {}", id);
        return ubmRepository.findById(id)
            .map(ubmMapper::toDto);
    }

    /**
     * Delete the ubm by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Ubm : {}", id);
        ubmRepository.deleteById(id);
    }
}
