package br.pa.gov.ssp.bombeiros.siscob.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.LocalDateFilter;

/**
 * Criteria class for the {@link br.pa.gov.ssp.bombeiros.siscob.domain.Ubm} entity. This class is used
 * in {@link br.pa.gov.ssp.bombeiros.siscob.web.rest.UbmResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ubms?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class UbmCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter sigla;

    private LocalDateFilter dataCriacao;

    private LongFilter cidadeSedeId;

    public UbmCriteria() {
    }

    public UbmCriteria(UbmCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.sigla = other.sigla == null ? null : other.sigla.copy();
        this.dataCriacao = other.dataCriacao == null ? null : other.dataCriacao.copy();
        this.cidadeSedeId = other.cidadeSedeId == null ? null : other.cidadeSedeId.copy();
    }

    @Override
    public UbmCriteria copy() {
        return new UbmCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getSigla() {
        return sigla;
    }

    public void setSigla(StringFilter sigla) {
        this.sigla = sigla;
    }

    public LocalDateFilter getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateFilter dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LongFilter getCidadeSedeId() {
        return cidadeSedeId;
    }

    public void setCidadeSedeId(LongFilter cidadeSedeId) {
        this.cidadeSedeId = cidadeSedeId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final UbmCriteria that = (UbmCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(sigla, that.sigla) &&
            Objects.equals(dataCriacao, that.dataCriacao) &&
            Objects.equals(cidadeSedeId, that.cidadeSedeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        sigla,
        dataCriacao,
        cidadeSedeId
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UbmCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (sigla != null ? "sigla=" + sigla + ", " : "") +
                (dataCriacao != null ? "dataCriacao=" + dataCriacao + ", " : "") +
                (cidadeSedeId != null ? "cidadeSedeId=" + cidadeSedeId + ", " : "") +
            "}";
    }

}
