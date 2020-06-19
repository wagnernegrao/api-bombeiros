package br.pa.gov.ssp.bombeiros.siscob.web.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pa.gov.ssp.bombeiros.siscob.service.OcorrenciaQueryService;
import br.pa.gov.ssp.bombeiros.siscob.service.OcorrenciaService;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.OcorrenciaCriteria;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.OcorrenciaDTO;
import br.pa.gov.ssp.bombeiros.siscob.web.rest.vm.ConsultaOcorrenciaVM;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing
 * {@link br.pa.gov.ssp.bombeiros.siscob.domain.Ocorrencia}.
 */
@RestController
@RequestMapping("/api")
public class OcorrenciaResource {

    private final Logger log = LoggerFactory.getLogger(OcorrenciaResource.class);

    private static final String ENTITY_NAME = "appsiscobBombeirosOcorrencia";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OcorrenciaService ocorrenciaService;

    private final OcorrenciaQueryService ocorrenciaQueryService;

    public OcorrenciaResource(OcorrenciaService ocorrenciaService, OcorrenciaQueryService ocorrenciaQueryService) {
        this.ocorrenciaService = ocorrenciaService;
        this.ocorrenciaQueryService = ocorrenciaQueryService;
    }

    /**
     * {@code POST  /ocorrencias} : get all occrencias
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of ocorrencias in body.
     */
    @PostMapping("/ocorrencias")
    public ResponseEntity<List<OcorrenciaDTO>> getAllOcorrencias(@RequestBody ConsultaOcorrenciaVM criteria,
            Pageable paginacao) {
        log.debug("REST request to get Ocorrencias by criteria: {}", criteria);
        List<OcorrenciaDTO> page = ocorrenciaQueryService.findByCriteria(criteria, paginacao);
        return ResponseEntity.ok().body(page);
    }

    /**
     * {@code GET  /ocorrencias/count} : count all the ocorrencias.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count
     *         in body.
     */
    @GetMapping("/ocorrencias/count")
    public ResponseEntity<Long> countOcorrencias(OcorrenciaCriteria criteria) {
        log.debug("REST request to count Ocorrencias by criteria: {}", criteria);
        return ResponseEntity.ok().body(ocorrenciaQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /ocorrencias/:id} : get the "id" ocorrencia.
     *
     * @param id the id of the ocorrenciaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the ocorrenciaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ocorrencias/{id}")
    public ResponseEntity<OcorrenciaDTO> getOcorrencia(@PathVariable Long id) {
        log.debug("REST request to get Ocorrencia : {}", id);
        Optional<OcorrenciaDTO> ocorrenciaDTO = ocorrenciaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(ocorrenciaDTO);
    }

}
