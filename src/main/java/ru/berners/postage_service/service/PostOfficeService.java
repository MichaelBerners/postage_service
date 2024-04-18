package ru.berners.postage_service.service;

import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.request.PostOfficeRequest;
import ru.berners.postage_service.domain.response.PostOfficeResponse;

public interface PostOfficeService {

    PostOfficeResponse create(PostOfficeRequest postOfficeRequest);
    PostOffice read(String index);
}
