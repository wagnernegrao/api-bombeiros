package br.pa.gov.ssp.bombeiros.siscob.service.mapper;


import br.pa.gov.ssp.bombeiros.siscob.domain.*;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.OcorrenciaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Ocorrencia} and its DTO {@link OcorrenciaDTO}.
 */
@Mapper(componentModel = "spring", uses = {CidadeMapper.class, BairroMapper.class, UbmMapper.class})
public interface OcorrenciaMapper extends EntityMapper<OcorrenciaDTO, Ocorrencia> {

    @Mapping(source = "cidade.id", target = "cidadeId")
    @Mapping(source = "cidade.nome", target = "cidadeNome")
    @Mapping(source = "bairro.id", target = "bairroId")
    @Mapping(source = "bairro.nome", target = "bairroNome")
    @Mapping(source = "ubm.id", target = "ubmId")
    @Mapping(source = "ubm.sigla", target = "ubmSigla")
    OcorrenciaDTO toDto(Ocorrencia ocorrencia);

    @Mapping(source = "cidadeId", target = "cidade")
    @Mapping(source = "bairroId", target = "bairro")
    @Mapping(source = "ubmId", target = "ubm")
    Ocorrencia toEntity(OcorrenciaDTO ocorrenciaDTO);

    default Ocorrencia fromId(Long id) {
        if (id == null) {
            return null;
        }
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setId(id);
        return ocorrencia;
    }
}
