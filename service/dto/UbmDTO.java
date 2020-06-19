package br.pa.gov.ssp.bombeiros.siscob.service.dto;

import java.time.LocalDate;
import java.io.Serializable;

/**
 * A DTO for the {@link br.pa.gov.ssp.bombeiros.siscob.domain.Ubm} entity.
 */
public class UbmDTO implements Serializable {
    
    private Long id;

    private String sigla;

    private LocalDate dataCriacao;


    private Long cidadeSedeId;

    private String cidadeSedeNome;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCidadeSedeId() {
        return cidadeSedeId;
    }

    public void setCidadeSedeId(Long cidadeId) {
        this.cidadeSedeId = cidadeId;
    }

    public String getCidadeSedeNome() {
        return cidadeSedeNome;
    }

    public void setCidadeSedeNome(String cidadeNome) {
        this.cidadeSedeNome = cidadeNome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UbmDTO)) {
            return false;
        }

        return id != null && id.equals(((UbmDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UbmDTO{" +
            "id=" + getId() +
            ", sigla='" + getSigla() + "'" +
            ", dataCriacao='" + getDataCriacao() + "'" +
            ", cidadeSedeId=" + getCidadeSedeId() +
            ", cidadeSedeNome='" + getCidadeSedeNome() + "'" +
            "}";
    }
}
