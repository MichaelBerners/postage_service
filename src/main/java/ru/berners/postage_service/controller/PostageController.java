package ru.berners.postage_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.berners.postage_service.domain.request.PostageRequest;
import ru.berners.postage_service.domain.response.PostageResponse;
import ru.berners.postage_service.service.PostageService;

@RestController
@RequestMapping("/v1/postages")
@AllArgsConstructor
@Tag(name = "Название", description = "описание")
public class PostageController {

    private final PostageService postageService;

    @PostMapping("/create")
    @Operation(summary = "создание почтового отправления")
    public PostageResponse create(@RequestBody @Valid PostageRequest postageRequest) {

        return postageService.create(postageRequest);
    }

    @GetMapping("/read")
    public String readPostageStatus(@RequestParam(value = "postageId") Long postageId) {

        return postageService.readPostageStatus(postageId);
    }

}
