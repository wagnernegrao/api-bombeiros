package br.pa.gov.ssp.bombeiros.siscob.service.impl;

import br.pa.gov.ssp.bombeiros.siscob.service.BairroService;
import br.pa.gov.ssp.bombeiros.siscob.domain.Bairro;
import br.pa.gov.ssp.bombeiros.siscob.domain.Bairro_;
import br.pa.gov.ssp.bombeiros.siscob.domain.Cidade;
import br.pa.gov.ssp.bombeiros.siscob.repository.BairroRepository;
import br.pa.gov.ssp.bombeiros.siscob.repository.filter.BairroFilter;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.BairroDTO;
import br.pa.gov.ssp.bombeiros.siscob.service.mapper.BairroMapper;
import br.pa.gov.ssp.bombeiros.siscob.service.mapper.CidadeMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import com.google.common.base.Predicate;

/**
 * Service Implementation for managing {@link Bairro}.
 */
@Service
@Transactional
public class BairroServiceImpl implements BairroService {

    private final Logger log = LoggerFactory.getLogger(BairroServiceImpl.class);

    private final BairroRepository bairroRepository;

    private final BairroMapper bairroMapper;

    @PersistenceContext
    private EntityManager manager;

    public BairroServiceImpl(final BairroRepository bairroRepository, final BairroMapper bairroMapper) {
        this.bairroRepository = bairroRepository;
        this.bairroMapper = bairroMapper;
    }

    /**
     * Save a bairro.
     *
     * @param bairroDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public BairroDTO save(final BairroDTO bairroDTO) {
        log.debug("Request to save Bairro : {}", bairroDTO);
        Bairro bairro = bairroMapper.toEntity(bairroDTO);
        bairro = bairroRepository.save(bairro);
        return bairroMapper.toDto(bairro);
    }

    /**
     * Get all the bairros.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BairroDTO> findAll(final Pageable pageable) {
        log.debug("Request to get all Bairros");
        return bairroRepository.findAll(pageable).map(bairroMapper::toDto);
    }

    /**
     * Get one bairro by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BairroDTO> findOne(final Long id) {
        log.debug("Request to get Bairro : {}", id);
        return bairroRepository.findById(id).map(bairroMapper::toDto);
    }

    @Override
    public List<Bairro> findByCidadeId(final BairroFilter bairroFilter) {
        final CriteriaBuilder builder = manager.getCriteriaBuilder();
        final CriteriaQuery<Bairro> criteria = builder.createQuery(Bairro.class);

        final Root<Bairro> root = criteria.from(Bairro.class);

        // criar as restricoes
        final javax.persistence.criteria.Predicate[] predicates = createRestrictions(bairroFilter, builder, root);
        criteria.where(predicates);

        final TypedQuery<Bairro> query = manager.createQuery(criteria);

        return query.getResultList();
    }

    private javax.persistence.criteria.Predicate[] createRestrictions(final BairroFilter bairroFilter,
            final CriteriaBuilder builder, final Root<Bairro> root) {

        final List<javax.persistence.criteria.Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(bairroFilter.getNome())) {
            predicates.add(builder.like(builder.lower(root.get("nome")), "%" + bairroFilter.getNome() + "%"));
        }
        // if (bairroFilter.getCidade() != null) {
        // predicates.add(
        // builder.like(builder.lower(root.get("cidadeId")), (Expression<String>)
        // bairroFilter.getCidade()));
        // }
        return predicates.toArray(new javax.persistence.criteria.Predicate[predicates.size()]);
    }

    @Override
    public List<Bairro> findAllByCidadeId(final Long id) {

        return bairroRepository.findAllByCidadeId(id);
    }

    @Override
    public List<Bairro> findAllByNome(String nome) {

        return bairroRepository.findAllByNome(nome);
    }

    @Override
    public List<Bairro> findAllByCidadeNome(String nome) {

        return bairroRepository.findAllByCidadeNome(nome);
    }

}
