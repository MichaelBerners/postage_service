package ru.berners.postage_service.service;

import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.repository.PostOfficeRepository;
import ru.berners.postage_service.domain.request.PostOfficeRequest;
import ru.berners.postage_service.domain.response.PostOfficeResponse;

public interface PostOfficeService {

    PostOfficeResponse create();
    /*PostOfficeResponse*/ PostOffice read(String index);

    PostOfficeResponse update(PostOfficeRequest postOfficeRequest);



}
