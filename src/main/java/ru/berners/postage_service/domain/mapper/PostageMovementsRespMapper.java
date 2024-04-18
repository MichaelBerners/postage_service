package ru.berners.postage_service.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.berners.postage_service.domain.entity.PostageMovements;
import ru.berners.postage_service.domain.response.PostageMovementsResponse;

@Mapper(componentModel = "spring")
public interface PostageMovementsRespMapper {

    @Mappings({
            @Mapping(target = "postOfficeIndex", source = "postageMovements.postOffice.index"),
            @Mapping(target = "postageId", source = "postageMovements.postage.id"),
            @Mapping(target = "status", source = "postageMovementStatus")
    })
    PostageMovementsResponse toPostageMovementsResp(PostageMovements postageMovements);
}
