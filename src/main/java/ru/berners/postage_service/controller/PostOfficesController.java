package ru.berners.postage_service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/create")
    public PostOfficeResponse create(PostOfficeRequest postOfficeRequest) {

        return postOfficeService.create(postOfficeRequest);
    }


}
