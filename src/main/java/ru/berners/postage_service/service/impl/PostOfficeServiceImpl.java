package ru.berners.postage_service.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.repository.PostOfficeRepository;
import ru.berners.postage_service.domain.response.PostOfficeResponse;
import ru.berners.postage_service.service.PostOfficeService;

@Service
@AllArgsConstructor
public class PostOfficeServiceImpl implements PostOfficeService {

    private final PostOfficeRepository postOfficeRepository;
    @Override
    public PostOfficeResponse create() {
        return null;
    }

    @Override
    public PostOffice read(String index) {
        return postOfficeRepository.findPostOfficesByIndex(index).orElseThrow(() -> new RuntimeException());

    }


}
