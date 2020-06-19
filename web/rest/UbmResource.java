package br.pa.gov.ssp.bombeiros.siscob.web.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.pa.gov.ssp.bombeiros.siscob.service.UbmQueryService;
import br.pa.gov.ssp.bombeiros.siscob.service.UbmService;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.UbmCriteria;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.UbmDTO;
import br.pa.gov.ssp.bombeiros.siscob.web.rest.vm.ConsultaBairroVM;
import br.pa.gov.ssp.bombeiros.siscob.web.rest.vm.ConsultaUbmVM;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing
 * {@link br.pa.gov.ssp.bombeiros.siscob.domain.Ubm}.
 */
@RestController
@RequestMapping("/api")
public class UbmResource {

    private final Logger log = LoggerFactory.getLogger(UbmResource.class);

    private static final String ENTITY_NAME = "appsiscobBombeirosUbm";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UbmService ubmService;

    private final UbmQueryService ubmQueryService;

    public UbmResource(UbmService ubmService, UbmQueryService ubmQueryService) {
        this.ubmService = ubmService;
        this.ubmQueryService = ubmQueryService;
    }

    /**
     * {@code GET  /ubms} : get all the ubms.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of ubms in body.
     */
    @GetMapping("/ubms")
    public ResponseEntity<List<UbmDTO>> getAllUbms(UbmCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Ubms by criteria: {}", criteria);
        Page<UbmDTO> page = ubmQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /***
     * {@code POST  /ubms} : get the specific ubms.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of ubms in body.
     */
    @PostMapping("/ubms")
    public ResponseEntity<List<UbmDTO>> getAllUbms(@RequestBody ConsultaUbmVM criteria, Pageable paginacao) {

        List<UbmDTO> page = ubmQueryService.findByCriteria(criteria, paginacao);

        return ResponseEntity.ok().body(page);
    }

    /**
     * {@code GET  /ubms/count} : count all the ubms.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count
     *         in body.
     */
    @GetMapping("/ubms/count")
    public ResponseEntity<Long> countUbms(UbmCriteria criteria) {
        log.debug("REST request to count Ubms by criteria: {}", criteria);
        return ResponseEntity.ok().body(ubmQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ubms/:id} : get the "id" ubm.
     *
     * @param id the id of the ubmDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the ubmDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ubms/{id}")
    public ResponseEntity<UbmDTO> getUbm(@PathVariable Long id) {
        log.debug("REST request to get Ubm : {}", id);
        Optional<UbmDTO> ubmDTO = ubmService.findOne(id);
        return ResponseUtil.wrapOrNotFound(ubmDTO);
    }

}
