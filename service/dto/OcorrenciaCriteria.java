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
import io.github.jhipster.service.filter.ZonedDateTimeFilter;

/**
 * Criteria class for the {@link br.pa.gov.ssp.bombeiros.siscob.domain.Ocorrencia} entity. This class is used
 * in {@link br.pa.gov.ssp.bombeiros.siscob.web.rest.OcorrenciaResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /ocorrencias?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class OcorrenciaCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter idOcorrencia;

    private LocalDateFilter dataOcorrencia;

    private StringFilter endereco;

    private StringFilter numero;

    private StringFilter telefone;

    private StringFilter cep;

    private StringFilter complemento;

    private ZonedDateTimeFilter horaChamada;

    private ZonedDateTimeFilter horaLocal;

    private ZonedDateTimeFilter horaTermino;

    private StringFilter situacao;

    private LongFilter cidadeId;

    private LongFilter bairroId;

    private LongFilter ubmId;

    public OcorrenciaCriteria() {
    }

    public OcorrenciaCriteria(OcorrenciaCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.idOcorrencia = other.idOcorrencia == null ? null : other.idOcorrencia.copy();
        this.dataOcorrencia = other.dataOcorrencia == null ? null : other.dataOcorrencia.copy();
        this.endereco = other.endereco == null ? null : other.endereco.copy();
        this.numero = other.numero == null ? null : other.numero.copy();
        this.telefone = other.telefone == null ? null : other.telefone.copy();
        this.cep = other.cep == null ? null : other.cep.copy();
        this.complemento = other.complemento == null ? null : other.complemento.copy();
        this.horaChamada = other.horaChamada == null ? null : other.horaChamada.copy();
        this.horaLocal = other.horaLocal == null ? null : other.horaLocal.copy();
        this.horaTermino = other.horaTermino == null ? null : other.horaTermino.copy();
        this.situacao = other.situacao == null ? null : other.situacao.copy();
        this.cidadeId = other.cidadeId == null ? null : other.cidadeId.copy();
        this.bairroId = other.bairroId == null ? null : other.bairroId.copy();
        this.ubmId = other.ubmId == null ? null : other.ubmId.copy();
    }

    @Override
    public OcorrenciaCriteria copy() {
        return new OcorrenciaCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(StringFilter idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public LocalDateFilter getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(LocalDateFilter dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public StringFilter getEndereco() {
        return endereco;
    }

    public void setEndereco(StringFilter endereco) {
        this.endereco = endereco;
    }

    public StringFilter getNumero() {
        return numero;
    }

    public void setNumero(StringFilter numero) {
        this.numero = numero;
    }

    public StringFilter getTelefone() {
        return telefone;
    }

    public void setTelefone(StringFilter telefone) {
        this.telefone = telefone;
    }

    public StringFilter getCep() {
        return cep;
    }

    public void setCep(StringFilter cep) {
        this.cep = cep;
    }

    public StringFilter getComplemento() {
        return complemento;
    }

    public void setComplemento(StringFilter complemento) {
        this.complemento = complemento;
    }

    public ZonedDateTimeFilter getHoraChamada() {
        return horaChamada;
    }

    public void setHoraChamada(ZonedDateTimeFilter horaChamada) {
        this.horaChamada = horaChamada;
    }

    public ZonedDateTimeFilter getHoraLocal() {
        return horaLocal;
    }

    public void setHoraLocal(ZonedDateTimeFilter horaLocal) {
        this.horaLocal = horaLocal;
    }

    public ZonedDateTimeFilter getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(ZonedDateTimeFilter horaTermino) {
        this.horaTermino = horaTermino;
    }

    public StringFilter getSituacao() {
        return situacao;
    }

    public void setSituacao(StringFilter situacao) {
        this.situacao = situacao;
    }

    public LongFilter getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(LongFilter cidadeId) {
        this.cidadeId = cidadeId;
    }

    public LongFilter getBairroId() {
        return bairroId;
    }

    public void setBairroId(LongFilter bairroId) {
        this.bairroId = bairroId;
    }

    public LongFilter getUbmId() {
        return ubmId;
    }

    public void setUbmId(LongFilter ubmId) {
        this.ubmId = ubmId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final OcorrenciaCriteria that = (OcorrenciaCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(idOcorrencia, that.idOcorrencia) &&
            Objects.equals(dataOcorrencia, that.dataOcorrencia) &&
            Objects.equals(endereco, that.endereco) &&
            Objects.equals(numero, that.numero) &&
            Objects.equals(telefone, that.telefone) &&
            Objects.equals(cep, that.cep) &&
            Objects.equals(complemento, that.complemento) &&
            Objects.equals(horaChamada, that.horaChamada) &&
            Objects.equals(horaLocal, that.horaLocal) &&
            Objects.equals(horaTermino, that.horaTermino) &&
            Objects.equals(situacao, that.situacao) &&
            Objects.equals(cidadeId, that.cidadeId) &&
            Objects.equals(bairroId, that.bairroId) &&
            Objects.equals(ubmId, that.ubmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        idOcorrencia,
        dataOcorrencia,
        endereco,
        numero,
        telefone,
        cep,
        complemento,
        horaChamada,
        horaLocal,
        horaTermino,
        situacao,
        cidadeId,
        bairroId,
        ubmId
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OcorrenciaCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (idOcorrencia != null ? "idOcorrencia=" + idOcorrencia + ", " : "") +
                (dataOcorrencia != null ? "dataOcorrencia=" + dataOcorrencia + ", " : "") +
                (endereco != null ? "endereco=" + endereco + ", " : "") +
                (numero != null ? "numero=" + numero + ", " : "") +
                (telefone != null ? "telefone=" + telefone + ", " : "") +
                (cep != null ? "cep=" + cep + ", " : "") +
                (complemento != null ? "complemento=" + complemento + ", " : "") +
                (horaChamada != null ? "horaChamada=" + horaChamada + ", " : "") +
                (horaLocal != null ? "horaLocal=" + horaLocal + ", " : "") +
                (horaTermino != null ? "horaTermino=" + horaTermino + ", " : "") +
                (situacao != null ? "situacao=" + situacao + ", " : "") +
                (cidadeId != null ? "cidadeId=" + cidadeId + ", " : "") +
                (bairroId != null ? "bairroId=" + bairroId + ", " : "") +
                (ubmId != null ? "ubmId=" + ubmId + ", " : "") +
            "}";
    }

}
