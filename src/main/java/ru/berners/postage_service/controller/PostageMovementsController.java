package ru.berners.postage_service.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.berners.postage_service.domain.entity.PostageMovements;
import ru.berners.postage_service.domain.request.PostageMovementsRequest;
import ru.berners.postage_service.domain.response.PostageMovementsResponse;
import ru.berners.postage_service.service.PostageMovementsService;

@RestController
@RequestMapping("/v1/postage-movements")
@AllArgsConstructor
public class PostageMovementsController {

    private PostageMovementsService postageMovementsService;

    @PostMapping("/registration")
    public PostageMovementsResponse registration(@RequestBody @Valid PostageMovementsRequest postageMovementsRequest) {

        return postageMovementsService.createRegistration(postageMovementsRequest);
    }

    @PostMapping("/arrival")
    public PostageMovementsResponse arrivalAtThePostOffice(@RequestBody @Valid PostageMovementsRequest postageMovementsRequest) {

        return postageMovementsService.createArrival(postageMovementsRequest);
    }

    @PostMapping("/departure")
    public PostageMovementsResponse departureFromThePostOffice(@RequestBody @Valid PostageMovementsRequest postageMovementsRequest) {

        return postageMovementsService.createDeparture(postageMovementsRequest);
    }

}
