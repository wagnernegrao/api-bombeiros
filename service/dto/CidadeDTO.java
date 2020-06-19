package br.pa.gov.ssp.bombeiros.siscob.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link br.pa.gov.ssp.bombeiros.siscob.domain.Cidade} entity.
 */
public class CidadeDTO implements Serializable {
    
    private Long id;

    private String nome;

    private String regiao;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CidadeDTO)) {
            return false;
        }

        return id != null && id.equals(((CidadeDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CidadeDTO{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", regiao='" + getRegiao() + "'" +
            "}";
    }
}
