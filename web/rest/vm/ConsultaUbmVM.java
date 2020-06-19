package br.pa.gov.ssp.bombeiros.siscob.web.rest.vm;

import java.time.LocalDate;

public class ConsultaUbmVM {

    private Long ubmId;
    private String sigla;
    private LocalDate dataCriacao;

    private LocalDate dataCriacaoInicio;
    private LocalDate dataCricaoFim;

    private String cidadeId;

    public Long getUbmId() {
        return ubmId;
    }

    public void setUbmId(Long ubmId) {
        this.ubmId = ubmId;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(String cidadeId) {
        this.cidadeId = cidadeId;
    }

    public LocalDate getDataCriacaoInicio() {
        return dataCriacaoInicio;
    }

    public void setDataCriacaoInicio(LocalDate dataCriacaoInicio) {
        this.dataCriacaoInicio = dataCriacaoInicio;
    }

    public LocalDate getDataCricaoFim() {
        return dataCricaoFim;
    }

    public void setDataCricaoFim(LocalDate dataCricaoFim) {
        this.dataCricaoFim = dataCricaoFim;
    }

}