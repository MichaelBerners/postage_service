package ru.berners.postage_service.domain.mapper;

import org.mapstruct.Mapper;
import ru.berners.postage_service.domain.entity.Postage;
import ru.berners.postage_service.domain.response.PostageResponse;

@Mapper(componentModel = "spring")
public interface PostageRespMapper {

    PostageResponse toPostageResp(Postage postage);
}
