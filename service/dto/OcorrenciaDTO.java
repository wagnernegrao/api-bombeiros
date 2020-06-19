package br.pa.gov.ssp.bombeiros.siscob.service.dto;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.io.Serializable;

/**
 * A DTO for the {@link br.pa.gov.ssp.bombeiros.siscob.domain.Ocorrencia} entity.
 */
public class OcorrenciaDTO implements Serializable {
    
    private Long id;

    private String idOcorrencia;

    private LocalDate dataOcorrencia;

    private String endereco;

    private String numero;

    private String telefone;

    private String cep;

    private String complemento;

    private ZonedDateTime horaChamada;

    private ZonedDateTime horaLocal;

    private ZonedDateTime horaTermino;

    private String situacao;


    private Long cidadeId;

    private String cidadeNome;

    private Long bairroId;

    private String bairroNome;

    private Long ubmId;

    private String ubmSigla;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(String idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public LocalDate getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(LocalDate dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public ZonedDateTime getHoraChamada() {
        return horaChamada;
    }

    public void setHoraChamada(ZonedDateTime horaChamada) {
        this.horaChamada = horaChamada;
    }

    public ZonedDateTime getHoraLocal() {
        return horaLocal;
    }

    public void setHoraLocal(ZonedDateTime horaLocal) {
        this.horaLocal = horaLocal;
    }

    public ZonedDateTime getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(ZonedDateTime horaTermino) {
        this.horaTermino = horaTermino;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getCidadeNome() {
        return cidadeNome;
    }

    public void setCidadeNome(String cidadeNome) {
        this.cidadeNome = cidadeNome;
    }

    public Long getBairroId() {
        return bairroId;
    }

    public void setBairroId(Long bairroId) {
        this.bairroId = bairroId;
    }

    public String getBairroNome() {
        return bairroNome;
    }

    public void setBairroNome(String bairroNome) {
        this.bairroNome = bairroNome;
    }

    public Long getUbmId() {
        return ubmId;
    }

    public void setUbmId(Long ubmId) {
        this.ubmId = ubmId;
    }

    public String getUbmSigla() {
        return ubmSigla;
    }

    public void setUbmSigla(String ubmSigla) {
        this.ubmSigla = ubmSigla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OcorrenciaDTO)) {
            return false;
        }

        return id != null && id.equals(((OcorrenciaDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OcorrenciaDTO{" +
            "id=" + getId() +
            ", idOcorrencia='" + getIdOcorrencia() + "'" +
            ", dataOcorrencia='" + getDataOcorrencia() + "'" +
            ", endereco='" + getEndereco() + "'" +
            ", numero='" + getNumero() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", cep='" + getCep() + "'" +
            ", complemento='" + getComplemento() + "'" +
            ", horaChamada='" + getHoraChamada() + "'" +
            ", horaLocal='" + getHoraLocal() + "'" +
            ", horaTermino='" + getHoraTermino() + "'" +
            ", situacao='" + getSituacao() + "'" +
            ", cidadeId=" + getCidadeId() +
            ", cidadeNome='" + getCidadeNome() + "'" +
            ", bairroId=" + getBairroId() +
            ", bairroNome='" + getBairroNome() + "'" +
            ", ubmId=" + getUbmId() +
            ", ubmSigla='" + getUbmSigla() + "'" +
            "}";
    }
}
