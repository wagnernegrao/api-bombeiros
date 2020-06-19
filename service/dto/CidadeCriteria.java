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

/**
 * Criteria class for the {@link br.pa.gov.ssp.bombeiros.siscob.domain.Cidade} entity. This class is used
 * in {@link br.pa.gov.ssp.bombeiros.siscob.web.rest.CidadeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cidades?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CidadeCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter nome;

    private StringFilter regiao;

    public CidadeCriteria() {
    }

    public CidadeCriteria(CidadeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.nome = other.nome == null ? null : other.nome.copy();
        this.regiao = other.regiao == null ? null : other.regiao.copy();
    }

    @Override
    public CidadeCriteria copy() {
        return new CidadeCriteria(this);
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

    public StringFilter getRegiao() {
        return regiao;
    }

    public void setRegiao(StringFilter regiao) {
        this.regiao = regiao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CidadeCriteria that = (CidadeCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(nome, that.nome) &&
            Objects.equals(regiao, that.regiao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        nome,
        regiao
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CidadeCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (nome != null ? "nome=" + nome + ", " : "") +
                (regiao != null ? "regiao=" + regiao + ", " : "") +
            "}";
    }

}
