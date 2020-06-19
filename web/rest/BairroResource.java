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

import br.pa.gov.ssp.bombeiros.siscob.domain.Bairro;
import br.pa.gov.ssp.bombeiros.siscob.repository.BairroRepository;
import br.pa.gov.ssp.bombeiros.siscob.repository.filter.BairroFilter;
import br.pa.gov.ssp.bombeiros.siscob.service.BairroQueryService;
import br.pa.gov.ssp.bombeiros.siscob.service.BairroService;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.BairroCriteria;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.BairroDTO;
import br.pa.gov.ssp.bombeiros.siscob.web.rest.vm.ConsultaBairroVM;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing
 * {@link br.pa.gov.ssp.bombeiros.siscob.domain.Bairro}.
 */
@RestController
@RequestMapping("/api")
public class BairroResource {

    private final Logger log = LoggerFactory.getLogger(BairroResource.class);

    private static final String ENTITY_NAME = "appsiscobBombeirosBairro";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BairroService bairroService;

    private final BairroQueryService bairroQueryService;

    private BairroRepository bairroRepository;

    public BairroResource(BairroService bairroService, BairroQueryService bairroQueryService) {
        this.bairroService = bairroService;
        this.bairroQueryService = bairroQueryService;
    }

    /**
     * {@code GET  /bairros} : get all the bairros.
     *
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of bairros in body.
     */
    @GetMapping("/bairros")
    public ResponseEntity<List<BairroDTO>> getAllBairros(BairroCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Bairros by criteria: {}", criteria);
        Page<BairroDTO> page = bairroQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil
                .generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code POST /bairros} : get the specific bairro.
     * 
     * @param pageable the pagination information.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of bairros in body.
     */

    @PostMapping("/bairros")
    public ResponseEntity<List<BairroDTO>> getAllBairros(@RequestBody ConsultaBairroVM criteria, Pageable paginacao) {
        log.debug("REST request to get Bairros by criteria: {}", criteria);

        List<BairroDTO> page = bairroQueryService.findByCriteria(criteria, paginacao);

        return ResponseEntity.ok().body(page);
    }

    /**
     * {@code GET  /bairros/count} : count all the bairros.
     *
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count
     *         in body.
     */
    @GetMapping("/bairros/count")
    public ResponseEntity<Long> countBairros(BairroCriteria criteria) {
        log.debug("REST request to count Bairros by criteria: {}", criteria);
        return ResponseEntity.ok().body(bairroQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /bairros/:id} : get the "id" bairro.
     *
     * @param id the id of the bairroDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the bairroDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/bairros/{id}")
    public ResponseEntity<BairroDTO> getBairro(@PathVariable Long id) {
        log.debug("REST request to get Bairro : {}", id);
        Optional<BairroDTO> bairroDTO = bairroService.findOne(id);
        return ResponseUtil.wrapOrNotFound(bairroDTO);
    }

    @GetMapping("/bairros/nome")
    public List<Bairro> searchCidades(BairroFilter bairroFilter) {
        List<Bairro> bairro = bairroService.findByCidadeId(bairroFilter);

        return bairro;
    }

    @GetMapping("/bairros/bynome/{nome}")
    public List<Bairro> byNome(@PathVariable(value = "nome") String nome) {
        List<Bairro> bairro = bairroService.findAllByNome(nome);

        return bairro;
    }

    @GetMapping("/bairros/bycidade/{cidade}")
    public List<Bairro> byCidade(@PathVariable(value = "cidade") Long cidade) {
        List<Bairro> bairro = bairroService.findAllByCidadeId(cidade);

        return bairro;
    }

    @GetMapping("/bairros/bycidadenome/{cidade}")
    public List<Bairro> byCidadeNome(@PathVariable(value = "cidade") String nome) {
        List<Bairro> bairro = bairroService.findAllByCidadeNome(nome);

        return bairro;
    }

}
