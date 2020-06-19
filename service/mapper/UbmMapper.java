package br.pa.gov.ssp.bombeiros.siscob.service.mapper;


import br.pa.gov.ssp.bombeiros.siscob.domain.*;
import br.pa.gov.ssp.bombeiros.siscob.service.dto.UbmDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Ubm} and its DTO {@link UbmDTO}.
 */
@Mapper(componentModel = "spring", uses = {CidadeMapper.class})
public interface UbmMapper extends EntityMapper<UbmDTO, Ubm> {

    @Mapping(source = "cidadeSede.id", target = "cidadeSedeId")
    @Mapping(source = "cidadeSede.nome", target = "cidadeSedeNome")
    UbmDTO toDto(Ubm ubm);

    @Mapping(source = "cidadeSedeId", target = "cidadeSede")
    Ubm toEntity(UbmDTO ubmDTO);

    default Ubm fromId(Long id) {
        if (id == null) {
            return null;
        }
        Ubm ubm = new Ubm();
        ubm.setId(id);
        return ubm;
    }
}
