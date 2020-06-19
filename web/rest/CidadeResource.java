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

import br.pa.gov.ssp.bombeiros.siscob.service.CidadeQueryService;
import br.pa.gov.ssp.bombeiros.siscob.service.CidadeService;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.CidadeCriteria;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.CidadeDTO;
import br.pa.gov.ssp.bombeiros.siscob.web.rest.vm.ConsultaCidadeVM;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing
 * {@link br.pa.gov.ssp.bombeiros.siscob.domain.Cidade}.
 */
@RestController
@RequestMapping("/api")
public class CidadeResource {

    private final Logger log = LoggerFactory.getLogger(CidadeResource.class);

    private static final String ENTITY_NAME = "appsiscobBombeirosCidade";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CidadeService cidadeService;

    private final CidadeQueryService cidadeQueryService;

    public CidadeResource(CidadeService cidadeService, CidadeQueryService cidadeQueryService) {
        this.cidadeService = cidadeService;
        this.cidadeQueryService = cidadeQueryService;
    }

    /**
     * {@code GET  /cidades} : get all the cidades.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of cidades in body.
     */
    @GetMapping("/cidades")
    public ResponseEntity<List<CidadeDTO>> getAllCidades(CidadeCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Cidades by criteria: {}", criteria);
        Page<CidadeDTO> page = cidadeQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code POST /cidades} : get the specific cidade.
     * 
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of cidades in body.
     */

    @PostMapping("/cidades")
    public ResponseEntity<List<CidadeDTO>> getAllCidades(@RequestBody ConsultaCidadeVM criteria, Pageable paginacao) {
        log.debug("REST request to post Cidades by criteria: {}", criteria);
        List<CidadeDTO> page = cidadeQueryService.findByCriteria(criteria, paginacao);

        return ResponseEntity.ok().body(page);
    }

    /**
     * {@code GET  /cidades/count} : count all the cidades.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count
     *         in body.
     */
    @GetMapping("/cidades/count")
    public ResponseEntity<Long> countCidades(CidadeCriteria criteria) {
        log.debug("REST request to count Cidades by criteria: {}", criteria);
        return ResponseEntity.ok().body(cidadeQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /cidades/:id} : get the "id" cidade.
     *
     * @param id the id of the cidadeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the cidadeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cidades/{id}")
    public ResponseEntity<CidadeDTO> getCidade(@PathVariable Long id) {
        log.debug("REST request to get Cidade : {}", id);
        Optional<CidadeDTO> cidadeDTO = cidadeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cidadeDTO);
    }

}
