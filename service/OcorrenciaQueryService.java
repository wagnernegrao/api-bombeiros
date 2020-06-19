package br.pa.gov.ssp.bombeiros.siscob.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.JoinType;

import br.pa.gov.ssp.bombeiros.siscob.web.rest.vm.ConsultaOcorrenciaVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import br.pa.gov.ssp.bombeiros.siscob.domain.Ocorrencia;
import br.pa.gov.ssp.bombeiros.siscob.domain.*; // for static metamodels
import br.pa.gov.ssp.bombeiros.siscob.repository.OcorrenciaRepository;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.OcorrenciaCriteria;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.OcorrenciaDTO;
import br.pa.gov.ssp.bombeiros.siscob.service.mapper.OcorrenciaMapper;

/**
 * Service for executing complex queries for {@link Ocorrencia} entities in the
 * database. The main input is a {@link OcorrenciaCriteria} which gets converted
 * to {@link Specification}, in a way that all the filters must apply. It
 * returns a {@link List} of {@link OcorrenciaDTO} or a {@link Page} of
 * {@link OcorrenciaDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class OcorrenciaQueryService extends QueryService<Ocorrencia> {

    private final Logger log = LoggerFactory.getLogger(OcorrenciaQueryService.class);

    private final OcorrenciaRepository ocorrenciaRepository;

    private final OcorrenciaMapper ocorrenciaMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public OcorrenciaQueryService(OcorrenciaRepository ocorrenciaRepository, OcorrenciaMapper ocorrenciaMapper) {
        this.ocorrenciaRepository = ocorrenciaRepository;
        this.ocorrenciaMapper = ocorrenciaMapper;
    }

    /**
     * Return a {@link List} of {@link OcorrenciaDTO} which matches the criteria
     * from the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<OcorrenciaDTO> findByCriteria(OcorrenciaCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Ocorrencia> specification = createSpecification(criteria);
        return ocorrenciaMapper.toDto(ocorrenciaRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link OcorrenciaDTO} which matches the criteria
     * from the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @param page     The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<OcorrenciaDTO> findByCriteria(OcorrenciaCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Ocorrencia> specification = createSpecification(criteria);
        return ocorrenciaRepository.findAll(specification, page).map(ocorrenciaMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(OcorrenciaCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Ocorrencia> specification = createSpecification(criteria);
        return ocorrenciaRepository.count(specification);
    }

    /**
     * Function to convert {@link OcorrenciaCriteria} to a {@link Specification}
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Ocorrencia> createSpecification(OcorrenciaCriteria criteria) {
        Specification<Ocorrencia> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Ocorrencia_.id));
            }
            if (criteria.getIdOcorrencia() != null) {
                specification = specification
                        .and(buildStringSpecification(criteria.getIdOcorrencia(), Ocorrencia_.idOcorrencia));
            }
            if (criteria.getDataOcorrencia() != null) {
                specification = specification
                        .and(buildRangeSpecification(criteria.getDataOcorrencia(), Ocorrencia_.dataOcorrencia));
            }
            if (criteria.getEndereco() != null) {
                specification = specification
                        .and(buildStringSpecification(criteria.getEndereco(), Ocorrencia_.endereco));
            }
            if (criteria.getNumero() != null) {
                specification = specification.and(buildStringSpecification(criteria.getNumero(), Ocorrencia_.numero));
            }
            if (criteria.getTelefone() != null) {
                specification = specification
                        .and(buildStringSpecification(criteria.getTelefone(), Ocorrencia_.telefone));
            }
            if (criteria.getCep() != null) {
                specification = specification.and(buildStringSpecification(criteria.getCep(), Ocorrencia_.cep));
            }
            if (criteria.getComplemento() != null) {
                specification = specification
                        .and(buildStringSpecification(criteria.getComplemento(), Ocorrencia_.complemento));
            }
            if (criteria.getHoraChamada() != null) {
                specification = specification
                        .and(buildRangeSpecification(criteria.getHoraChamada(), Ocorrencia_.horaChamada));
            }
            if (criteria.getHoraLocal() != null) {
                specification = specification
                        .and(buildRangeSpecification(criteria.getHoraLocal(), Ocorrencia_.horaLocal));
            }
            if (criteria.getHoraTermino() != null) {
                specification = specification
                        .and(buildRangeSpecification(criteria.getHoraTermino(), Ocorrencia_.horaTermino));
            }
            if (criteria.getSituacao() != null) {
                specification = specification
                        .and(buildStringSpecification(criteria.getSituacao(), Ocorrencia_.situacao));
            }
            if (criteria.getCidadeId() != null) {
                specification = specification.and(buildSpecification(criteria.getCidadeId(),
                        root -> root.join(Ocorrencia_.cidade, JoinType.LEFT).get(Cidade_.id)));
            }
            if (criteria.getBairroId() != null) {
                specification = specification.and(buildSpecification(criteria.getBairroId(),
                        root -> root.join(Ocorrencia_.bairro, JoinType.LEFT).get(Bairro_.id)));
            }
            if (criteria.getUbmId() != null) {
                specification = specification.and(buildSpecification(criteria.getUbmId(),
                        root -> root.join(Ocorrencia_.ubm, JoinType.LEFT).get(Ubm_.id)));
            }
        }
        return specification;
    }

    @Transactional(readOnly = true)
    public List<OcorrenciaDTO> findByCriteria(ConsultaOcorrenciaVM criteria, Pageable paginacao) {

        String sql = " select * from ocorrencia AS c WHERE id > 0 ";

        if (criteria != null) {
            if (criteria.getCidadeId() != null) {
                sql += "AND ( c.idcidade LIKE :cidadeId )";
            }

            if (criteria.getBairroId() != null) {
                sql += "AND ( c.idbairro LIKE :bairroId )";
            }

            if (criteria.getUbmId() != null) {
                sql += "AND ( c.idubm LIKE :ubmId )";
            }

            if (criteria.getDataOcorrenciaInicio() != null && criteria.getDataOcorrenciaFim() != null) {
                sql += " AND ( c.data_ocor BETWEEN :dataInicioDia AND :dataFimDia )";
            }

            if (criteria.getEndereco() != null && criteria.getEndereco().trim().length() > 0) {
                sql += " AND ( c.endereco LIKE :endereco )";
            }

            if (criteria.getSituacao() != null) {
                sql += " AND ( c.situacao LIKE :situacao )";
            }

            if (criteria.getLatitude() != null && criteria.getLongitude() != null && criteria.getRaio() != null
                    && criteria.getRaio() > 0) {
                sql += "AND (acos(sin(radians(:latitude)) * sin((radians(c.segLat)))"
                        + " + cos(radians(:latitude)) * cos(radians(c.segLat))"
                        + " * cos((radians(:longitude) - radians(c.segLong))))" + " * 6372.795477598) < :raio)";
            }
        }

        Query query = entityManager.createNativeQuery(sql, Ocorrencia.class);

        if (paginacao != null) {
            query.setFirstResult((paginacao.getPageNumber() * paginacao.getPageSize()));
            query.setMaxResults(paginacao.getPageSize());
        }

        if (criteria != null) {
            if (criteria.getCidadeId() != null) {
                query.setParameter("cidadeId", criteria.getCidadeId());
            }

            if (criteria.getBairroId() != null) {
                query.setParameter("bairroId", criteria.getBairroId());
            }

            if (criteria.getUbmId() != null) {
                query.setParameter("ubmId", criteria.getUbmId());
            }

            if (criteria.getDataOcorrenciaInicio() != null && criteria.getDataOcorrenciaFim() != null) {
                query.setParameter("dataInicioDia", criteria.getDataOcorrenciaInicio().atStartOfDay());
                query.setParameter("dataFimDia", criteria.getDataOcorrenciaFim().plusDays(1).atStartOfDay());
            }

            if (criteria.getEndereco() != null && criteria.getEndereco().trim().length() > 0) {
                query.setParameter("endereco", "%" + criteria.getEndereco() + "%");
            }

            if (criteria.getSituacao() != null) {
                query.setParameter("situacao", criteria.getSituacao());
            }

            if (criteria.getLongitude() != null && criteria.getLatitude() != null && criteria.getRaio() != null
                    && criteria.getRaio() > 0) {
                query.setParameter("longitude", criteria.getLongitude());
                query.setParameter("latitude", criteria.getLatitude());
                query.setParameter("raio", criteria.getRaio());
            }
        }

        List<OcorrenciaDTO> resultado = ocorrenciaMapper.toDto(query.getResultList());

        return resultado;
    }

}
