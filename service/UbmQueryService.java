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

// for static metamodels
import br.pa.gov.ssp.bombeiros.siscob.domain.Cidade_;
import br.pa.gov.ssp.bombeiros.siscob.domain.Ubm;
import br.pa.gov.ssp.bombeiros.siscob.domain.Ubm_;
import br.pa.gov.ssp.bombeiros.siscob.repository.UbmRepository;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.UbmCriteria;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.UbmDTO;
import br.pa.gov.ssp.bombeiros.siscob.service.mapper.UbmMapper;
import br.pa.gov.ssp.bombeiros.siscob.web.rest.vm.ConsultaUbmVM;
import io.github.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Ubm} entities in the
 * database. The main input is a {@link UbmCriteria} which gets converted to
 * {@link Specification}, in a way that all the filters must apply. It returns a
 * {@link List} of {@link UbmDTO} or a {@link Page} of {@link UbmDTO} which
 * fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class UbmQueryService extends QueryService<Ubm> {

    private final Logger log = LoggerFactory.getLogger(UbmQueryService.class);

    private final UbmRepository ubmRepository;

    private final UbmMapper ubmMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public UbmQueryService(UbmRepository ubmRepository, UbmMapper ubmMapper) {
        this.ubmRepository = ubmRepository;
        this.ubmMapper = ubmMapper;
    }

    /**
     * Return a {@link List} of {@link UbmDTO} which matches the criteria from the
     * database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<UbmDTO> findByCriteria(UbmCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Ubm> specification = createSpecification(criteria);
        return ubmMapper.toDto(ubmRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link UbmDTO} which matches the criteria from the
     * database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @param page     The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<UbmDTO> findByCriteria(UbmCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Ubm> specification = createSpecification(criteria);
        return ubmRepository.findAll(specification, page).map(ubmMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(UbmCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Ubm> specification = createSpecification(criteria);
        return ubmRepository.count(specification);
    }

    /**
     * Function to convert {@link UbmCriteria} to a {@link Specification}
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Ubm> createSpecification(UbmCriteria criteria) {
        Specification<Ubm> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Ubm_.id));
            }
            if (criteria.getSigla() != null) {
                specification = specification.and(buildStringSpecification(criteria.getSigla(), Ubm_.sigla));
            }
            if (criteria.getDataCriacao() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getDataCriacao(), Ubm_.dataCriacao));
            }
            if (criteria.getCidadeSedeId() != null) {
                specification = specification.and(buildSpecification(criteria.getCidadeSedeId(),
                        root -> root.join(Ubm_.cidadeSede, JoinType.LEFT).get(Cidade_.id)));
            }
        }
        return specification;
    }

    @Transactional(readOnly = true)
    public List<UbmDTO> findByCriteria(ConsultaUbmVM criteria, Pageable paginacao) {

        String sql = " select * from ubm AS u WHERE u.idubm > 0 ";

        if (criteria != null) {
            if (criteria.getUbmId() != null) {
                sql += "AND ( u.idubm LIKE :ubmId )";
            }

            if (criteria.getSigla() != null) {
                sql += "AND ( u.sigla LIKE :sigla ) ";
            }

            if (criteria.getDataCriacaoInicio() != null && criteria.getDataCricaoFim() != null) {
                sql += "AND ( u.datacriacao BETWEEN :dataCriacaoInicio AND :dataCricaoFim ) ";
            }

            if (criteria.getCidadeId() != null) {
                sql += "AND ( u.id_cidade_sede LIKE :cidadeId )";
            }
        }

        Query query = entityManager.createNativeQuery(sql, Ubm.class);

        if (paginacao != null) {
            query.setFirstResult((paginacao.getPageNumber() * paginacao.getPageSize()));
            query.setMaxResults(paginacao.getPageSize());
        }

        if (criteria != null) {
            if (criteria.getUbmId() != null) {
                query.setParameter("ubmId", criteria.getUbmId());
            }

            if (criteria.getSigla() != null) {
                query.setParameter("sigla", "%" + criteria.getSigla() + "%");
            }

            // if (criteria.getDataCriacao() != null) {
            // query.setParameter("dataCriacao", criteria.getDataCriacao().atStartOfDay());
            // }

            if (criteria.getDataCriacaoInicio() != null && criteria.getDataCricaoFim() != null) {
                query.setParameter("dataInicioDia", criteria.getDataCriacaoInicio().atStartOfDay());
                query.setParameter("dataFimDia", criteria.getDataCricaoFim().plusDays(1).atStartOfDay());
            }

            if (criteria.getCidadeId() != null) {
                query.setParameter("cidadeId", criteria.getCidadeId());
            }
        }

        List<UbmDTO> resultado = ubmMapper.toDto(query.getResultList());

        return resultado;

    }
}
