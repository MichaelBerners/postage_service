package ru.berners.postage_service.service;


import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.entity.Postage;
import ru.berners.postage_service.domain.entity.PostageStatus;
import ru.berners.postage_service.domain.request.PostageRequest;
import ru.berners.postage_service.domain.response.PostageMovementsResponse;
import ru.berners.postage_service.domain.response.PostageResponse;

import java.util.List;

public interface PostageService {

    PostageResponse create(PostageRequest postageRequest);

    Postage read(Long id);

    String readPostageStatus(Long id);

    PostageResponse updateStatus(Long id, PostageStatus postageStatus);

    List<PostageMovementsResponse> readHistoryMovements(Long id);




}
