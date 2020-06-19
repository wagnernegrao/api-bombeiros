package br.pa.gov.ssp.bombeiros.siscob.service.dto;

import java.io.Serializable;
import java.util.Objects;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link br.pa.gov.ssp.bombeiros.siscob.domain.Bairro}
 * entity. This class is used in
 * {@link br.pa.gov.ssp.bombeiros.siscob.web.rest.BairroResource} to receive all
 * the possible filtering options from the Http GET request parameters. For
 * example the following could be a valid request:
 * {@code /bairros?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific
 * {@link Filter} class are used, we need to use fix type specific filters.
 */
public class BairroCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter nome;

    private LongFilter cidadeId;

    public BairroCriteria() {
    }

    public BairroCriteria(BairroCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.nome = other.nome == null ? null : other.nome.copy();
        this.cidadeId = other.cidadeId == null ? null : other.cidadeId.copy();
    }

    @Override
    public BairroCriteria copy() {
        return new BairroCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getNome() {
        return nome;
    }

    public void setNome(StringFilter nome) {
        this.nome = nome;
    }

    public LongFilter getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(LongFilter cidadeId) {
        this.cidadeId = cidadeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BairroCriteria that = (BairroCriteria) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome)
                && Objects.equals(cidadeId, that.cidadeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cidadeId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BairroCriteria{" + (id != null ? "id=" + id + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
                + (cidadeId != null ? "cidadeId=" + cidadeId + ", " : "") + "}";
    }

}
