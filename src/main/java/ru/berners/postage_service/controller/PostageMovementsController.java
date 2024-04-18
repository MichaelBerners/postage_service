package ru.berners.postage_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.berners.postage_service.domain.request.PostageMovementsRequest;
import ru.berners.postage_service.domain.response.PostageMovementsResponse;
import ru.berners.postage_service.service.PostageMovementsService;

@RestController
@RequestMapping("/v1/postage-movements")
@AllArgsConstructor
public class PostageMovementsController {

    private PostageMovementsService postageMovementsService;

    @Operation(summary = "регистрация почтового отправления в отделении")
    @PostMapping(path = "/registration", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostageMovementsResponse registration(@RequestBody @Valid PostageMovementsRequest postageMovementsRequest) {

        return postageMovementsService.createRegistration(postageMovementsRequest);
    }

    @Operation(summary = "получение почтового отправления в отделении")
    @PostMapping(path = "/arrival", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostageMovementsResponse arrivalAtThePostOffice(@RequestBody @Valid PostageMovementsRequest postageMovementsRequest) {

        return postageMovementsService.createArrival(postageMovementsRequest);
    }

    @Operation(summary = "убытие почтового отправления из отделения")
    @PostMapping(path = "/departure", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostageMovementsResponse departureFromThePostOffice(@RequestBody @Valid PostageMovementsRequest postageMovementsRequest) {

        return postageMovementsService.createDeparture(postageMovementsRequest);
    }

}
