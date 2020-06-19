package br.pa.gov.ssp.bombeiros.siscob.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import br.pa.gov.ssp.bombeiros.siscob.domain.Cidade;
import br.pa.gov.ssp.bombeiros.siscob.domain.*; // for static metamodels
import br.pa.gov.ssp.bombeiros.siscob.repository.CidadeRepository;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.CidadeCriteria;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.CidadeDTO;
import br.pa.gov.ssp.bombeiros.siscob.service.mapper.CidadeMapper;
import br.pa.gov.ssp.bombeiros.siscob.web.rest.vm.ConsultaCidadeVM;

/**
 * Service for executing complex queries for {@link Cidade} entities in the
 * database. The main input is a {@link CidadeCriteria} which gets converted to
 * {@link Specification}, in a way that all the filters must apply. It returns a
 * {@link List} of {@link CidadeDTO} or a {@link Page} of {@link CidadeDTO}
 * which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class CidadeQueryService extends QueryService<Cidade> {

    private final Logger log = LoggerFactory.getLogger(CidadeQueryService.class);

    private final CidadeRepository cidadeRepository;

    private final CidadeMapper cidadeMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public CidadeQueryService(CidadeRepository cidadeRepository, CidadeMapper cidadeMapper) {
        this.cidadeRepository = cidadeRepository;
        this.cidadeMapper = cidadeMapper;
    }

    /**
     * Return a {@link List} of {@link CidadeDTO} which matches the criteria from
     * the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<CidadeDTO> findByCriteria(CidadeCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Cidade> specification = createSpecification(criteria);
        return cidadeMapper.toDto(cidadeRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link CidadeDTO} which matches the criteria from
     * the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @param page     The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<CidadeDTO> findByCriteria(CidadeCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Cidade> specification = createSpecification(criteria);
        return cidadeRepository.findAll(specification, page).map(cidadeMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(CidadeCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Cidade> specification = createSpecification(criteria);
        return cidadeRepository.count(specification);
    }

    /**
     * Function to convert {@link CidadeCriteria} to a {@link Specification}
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Cidade> createSpecification(CidadeCriteria criteria) {
        Specification<Cidade> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Cidade_.id));
            }
            if (criteria.getNome() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNome(), Cidade_.nome));
            }
            if (criteria.getRegiao() != null) {
                specification = specification.and(buildStringSpecification(criteria.getRegiao(), Cidade_.regiao));
            }
        }
        return specification;
    }

    @Transactional(readOnly = true)
    public List<CidadeDTO> findByCriteria(ConsultaCidadeVM criteria, Pageable paginacao) {

        String sql = " select * from cidade AS c Where c.idcidade > 0 ";

        if (criteria != null) {
            if (criteria.getCidadeId() != null) {
                sql += "AND ( c.idcidade LIKE :cidadeId ) ";
            }

            if (criteria.getNome() != null) {
                sql += "AND ( c.nome LIKE :nome ) ";
            }

            if (criteria.getRegiao() != null) {
                sql += "AND ( c.regiao LIKE :regiao ) ";
            }
        }

        Query query = entityManager.createNativeQuery(sql, Cidade.class);

        if (paginacao != null) {
            query.setFirstResult((paginacao.getPageNumber() * paginacao.getPageSize()));
            query.setMaxResults(paginacao.getPageSize());
        }

        if (criteria != null) {
            if (criteria.getCidadeId() != null) {
                query.setParameter("cidadeId", criteria.getCidadeId());
            }

            if (criteria.getNome() != null) {
                query.setParameter("nome", "%" + criteria.getNome() + "%");
            }

            if (criteria.getRegiao() != null) {
                query.setParameter("regiao", "%" + criteria.getRegiao() + "%");
            }
        }

        List<CidadeDTO> resultado = cidadeMapper.toDto(query.getResultList());

        return resultado;
    }
}
