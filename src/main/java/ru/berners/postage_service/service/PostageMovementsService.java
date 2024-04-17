package ru.berners.postage_service.service;


import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.entity.Postage;
import ru.berners.postage_service.domain.request.PostageMovementsRequest;
import ru.berners.postage_service.domain.response.PostageMovementsResponse;
import ru.berners.postage_service.domain.response.PostageResponse;

import java.util.List;

public interface PostageMovementsService {


    PostageMovementsResponse createRegistration(String indexPostOffice, Postage postage);
    PostageMovementsResponse createArrival(String indexPostOffice, Long postageId);
    PostageMovementsResponse createDeparture(String indexPostOffice, Long postageId);




}
