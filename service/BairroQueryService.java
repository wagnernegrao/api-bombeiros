package br.pa.gov.ssp.bombeiros.siscob.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.JoinType;

import br.pa.gov.ssp.bombeiros.siscob.web.rest.vm.ConsultaBairroVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import br.pa.gov.ssp.bombeiros.siscob.domain.Bairro;
import br.pa.gov.ssp.bombeiros.siscob.domain.*; // for static metamodels
import br.pa.gov.ssp.bombeiros.siscob.repository.BairroRepository;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.BairroCriteria;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.BairroDTO;
import br.pa.gov.ssp.bombeiros.siscob.service.mapper.BairroMapper;

/**
 * Service for executing complex queries for {@link Bairro} entities in the
 * database. The main input is a {@link BairroCriteria} which gets converted to
 * {@link Specification}, in a way that all the filters must apply. It returns a
 * {@link List} of {@link BairroDTO} or a {@link Page} of {@link BairroDTO}
 * which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BairroQueryService extends QueryService<Bairro> {

    private final Logger log = LoggerFactory.getLogger(BairroQueryService.class);

    private final BairroRepository bairroRepository;

    private final BairroMapper bairroMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public BairroQueryService(BairroRepository bairroRepository, BairroMapper bairroMapper) {
        this.bairroRepository = bairroRepository;
        this.bairroMapper = bairroMapper;
    }

    /**
     * Return a {@link List} of {@link BairroDTO} which matches the criteria from
     * the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<BairroDTO> findByCriteria(BairroCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Bairro> specification = createSpecification(criteria);
        return bairroMapper.toDto(bairroRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link BairroDTO} which matches the criteria from
     * the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @param page     The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<BairroDTO> findByCriteria(BairroCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Bairro> specification = createSpecification(criteria);
        return bairroRepository.findAll(specification, page).map(bairroMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BairroCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Bairro> specification = createSpecification(criteria);
        return bairroRepository.count(specification);
    }

    /**
     * Function to convert {@link BairroCriteria} to a {@link Specification}
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Bairro> createSpecification(BairroCriteria criteria) {
        Specification<Bairro> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Bairro_.id));
            }
            if (criteria.getNome() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNome(), Bairro_.nome));
            }
            if (criteria.getCidadeId() != null) {
                specification = specification.and(buildSpecification(criteria.getCidadeId(),
                        root -> root.join(Bairro_.cidade, JoinType.LEFT).get(Cidade_.id)));
            }
        }
        return specification;
    }

    @Transactional(readOnly = true)
    public List<BairroDTO> findByCriteria(ConsultaBairroVM criteria, Pageable paginacao) {

        String sql = " select * from bairro AS c WHERE c.idbairro > 0 ";

        if (criteria != null) {
            if (criteria.getNome() != null) {
                sql += "AND ( c.NOME LIKE :nome )";
            }

            if (criteria.getBairroId() != null) {
                sql += "AND ( c.idbairro LIKE :bairroId )";
            }

            if (criteria.getCidadeId() != null) {
                sql += "AND ( c.idcidade LIKE :cidadeId )";
            }
        }

        Query query = entityManager.createNativeQuery(sql, Bairro.class);

        if (paginacao != null) {
            query.setFirstResult((paginacao.getPageNumber() * paginacao.getPageSize()));
            query.setMaxResults(paginacao.getPageSize());
        }

        if (criteria != null) {
            if (criteria.getNome() != null && criteria.getNome().trim().length() > 0) {
                query.setParameter("nome", "%" + criteria.getNome() + "%");
            }

            if (criteria.getBairroId() != null) {
                query.setParameter("bairroId", criteria.getBairroId());
            }

            if (criteria.getCidadeId() != null) {
                query.setParameter("cidadeId", criteria.getCidadeId());
            }

        }

        List<BairroDTO> resultado = bairroMapper.toDto(query.getResultList());

        return resultado;
    }
}
