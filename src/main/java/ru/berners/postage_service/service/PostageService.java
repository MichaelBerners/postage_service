package ru.berners.postage_service.service;


import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.entity.PostageStatus;
import ru.berners.postage_service.domain.request.PostageRequest;
import ru.berners.postage_service.domain.response.PostageMovementsResponse;
import ru.berners.postage_service.domain.response.PostageResponse;

import java.util.List;

public interface PostageService {

    PostageResponse create(PostageRequest postageRequest);

    PostageResponse updateStatus(Long id, PostageStatus postageStatus);

    List<PostageMovementsResponse> readHistoryMovements(String index);

    void departureFromThePostOffice(PostOffice postOffice);
    void arrivalFromThePostOffice(PostOffice postOffice);


}
