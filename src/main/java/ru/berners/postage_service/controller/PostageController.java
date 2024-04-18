package ru.berners.postage_service.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.berners.postage_service.domain.request.PostageRequest;
import ru.berners.postage_service.domain.response.PostageResponse;
import ru.berners.postage_service.service.PostageService;

@RestController
@RequestMapping("/v1/postages")
@AllArgsConstructor
public class PostageController {

    private final PostageService postageService;

    @PostMapping("/create")
    public PostageResponse create(@RequestBody @Valid PostageRequest postageRequest) {

        return postageService.create(postageRequest);
    }

    @GetMapping("/read")
    public String readPostageStatus(@RequestParam(value = "postageId") Long postageId) {

        return postageService.readPostageStatus(postageId);
    }

}
