package ru.berners.postage_service.domain.mapper;

import org.mapstruct.Mapper;
import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.response.PostOfficeResponse;

@Mapper(componentModel = "spring")
public interface PostOfficeRespMapper {

    PostOfficeResponse toPostOfficeResp(PostOffice postOffice);
}
