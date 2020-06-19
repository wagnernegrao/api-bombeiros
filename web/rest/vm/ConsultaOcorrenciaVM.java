package br.pa.gov.ssp.bombeiros.siscob.web.rest.vm;

import java.time.LocalDate;

public class ConsultaOcorrenciaVM {

    private LocalDate dataOcorrencia;
    //OU
    private LocalDate dataOcorrenciaInicio;
    private LocalDate dataOcorrenciaFim;

    private String endereco;
    private String situacao;

    private Long cidadeId;
    private Long bairroId;
    private Long ubmId;

    private Double latitude;
    private Double longitude;
    private Double raio;


    public LocalDate getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(LocalDate dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public LocalDate getDataOcorrenciaInicio() {
        return dataOcorrenciaInicio;
    }

    public void setDataOcorrenciaInicio(LocalDate dataOcorrenciaInicio) {
        this.dataOcorrenciaInicio = dataOcorrenciaInicio;
    }

    public LocalDate getDataOcorrenciaFim() {
        return dataOcorrenciaFim;
    }

    public void setDataOcorrenciaFim(LocalDate dataOcorrenciaFim) {
        this.dataOcorrenciaFim = dataOcorrenciaFim;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public Long getBairroId() {
        return bairroId;
    }

    public void setBairroId(Long bairroId) {
        this.bairroId = bairroId;
    }

    public Long getUbmId() {
        return ubmId;
    }

    public void setUbmId(Long ubmId) {
        this.ubmId = ubmId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getRaio() {
        return raio;
    }

    public void setRaio(Double raio) {
        this.raio = raio;
    }
}
