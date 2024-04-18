package ru.berners.postage_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.berners.postage_service.domain.request.PostOfficeRequest;
import ru.berners.postage_service.domain.response.PostOfficeResponse;
import ru.berners.postage_service.service.PostOfficeService;

@RestController
@RequestMapping("/v1/post-offices")
@AllArgsConstructor
public class PostOfficesController {

    private final PostOfficeService postOfficeService;

    @Operation(summary = "создание нового почтового отделения")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostOfficeResponse create(@RequestBody @Valid PostOfficeRequest postOfficeRequest) {

        return postOfficeService.create(postOfficeRequest);
    }
}
