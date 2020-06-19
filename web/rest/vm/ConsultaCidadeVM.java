package br.pa.gov.ssp.bombeiros.siscob.web.rest.vm;

public class ConsultaCidadeVM {

    private Long cidadeId;
    private String nome;
    private String regiao;
    private Long risp;

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Long getRisp() {
        return risp;
    }

    public void setRisp(Long risp) {
        this.risp = risp;
    }

}