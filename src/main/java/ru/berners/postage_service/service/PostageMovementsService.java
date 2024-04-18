package ru.berners.postage_service.service;


import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.entity.Postage;
import ru.berners.postage_service.domain.request.PostageMovementsRequest;
import ru.berners.postage_service.domain.response.PostageMovementsResponse;
import ru.berners.postage_service.domain.response.PostageResponse;

import java.util.List;

public interface PostageMovementsService {


    PostageMovementsResponse createRegistration(PostageMovementsRequest postageMovementsRequest);
    PostageMovementsResponse createArrival(PostageMovementsRequest postageMovementsRequest);
    PostageMovementsResponse createDeparture(PostageMovementsRequest postageMovementsRequest);




}
