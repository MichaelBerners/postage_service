package ru.berners.postage_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.berners.postage_service.domain.entity.PostageStatus;
import ru.berners.postage_service.domain.request.PostageRequest;
import ru.berners.postage_service.domain.response.PostageResponse;
import ru.berners.postage_service.service.PostageService;

@RestController
@RequestMapping("/v1/postages")
@AllArgsConstructor
public class PostageController {

    private final PostageService postageService;

    @Operation(summary = "создание почтового отправления")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostageResponse create(@RequestBody @Valid PostageRequest postageRequest) {

        return postageService.create(postageRequest);
    }

    @Operation(summary = "просмотр статуса почтового отправления")
    @GetMapping(path = "/{postageId}/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public PostageStatus findPostageStatus(@PathVariable(value = "postageId") Long postageId) {

        return postageService.findPostageStatus(postageId);
    }
}
