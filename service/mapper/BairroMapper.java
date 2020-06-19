package br.pa.gov.ssp.bombeiros.siscob.service.mapper;

import br.pa.gov.ssp.bombeiros.siscob.domain.*;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.BairroDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Bairro} and its DTO {@link BairroDTO}.
 */
@Mapper(componentModel = "spring", uses = { CidadeMapper.class })
public interface BairroMapper extends EntityMapper<BairroDTO, Bairro> {

    @Mapping(source = "cidade.id", target = "cidadeId")
    @Mapping(source = "cidade.nome", target = "cidadeNome")
    BairroDTO toDto(Bairro bairro);

    @Mapping(source = "cidadeId", target = "cidade")
    Bairro toEntity(BairroDTO bairroDTO);

    default Bairro fromId(Long id) {
        if (id == null) {
            return null;
        }
        Bairro bairro = new Bairro();
        bairro.setId(id);
        return bairro;
    }
}
