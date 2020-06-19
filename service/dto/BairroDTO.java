package br.pa.gov.ssp.bombeiros.siscob.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link br.pa.gov.ssp.bombeiros.siscob.domain.Bairro} entity.
 */
public class BairroDTO implements Serializable {
    
    private Long id;

    private String nome;


    private Long cidadeId;

    private String cidadeNome;
    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BairroDTO)) {
            return false;
        }

        return id != null && id.equals(((BairroDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BairroDTO{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", cidadeId=" + getCidadeId() +
            ", cidadeNome='" + getCidadeNome() + "'" +
            "}";
    }
}
