package ru.berners.postage_service.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.exception.PostOfficeNotFound;
import ru.berners.postage_service.domain.exception.PostageAlreadyExistsException;
import ru.berners.postage_service.domain.mapper.PostOfficeRespMapper;
import ru.berners.postage_service.domain.repository.PostOfficeRepository;
import ru.berners.postage_service.domain.request.PostOfficeRequest;
import ru.berners.postage_service.domain.response.PostOfficeResponse;
import ru.berners.postage_service.service.PostOfficeService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PostOfficeServiceImpl implements PostOfficeService {

    private final PostOfficeRepository postOfficeRepository;
    private final PostOfficeRespMapper postOfficeRespMapper;

    @Override
    public PostOfficeResponse create(PostOfficeRequest postOfficeRequest) {
        final Optional<PostOffice> existingByIndex = postOfficeRepository.findByIndex(postOfficeRequest.getIndex());

        if(existingByIndex.isPresent()) {
            throw new PostageAlreadyExistsException();
        }

        PostOffice postOffice = new PostOffice();
        postOffice.setIndex(postOfficeRequest.getIndex());
        postOffice.setName(postOfficeRequest.getName());
        postOffice.setAddress(postOfficeRequest.getAddress());
        PostOffice save = postOfficeRepository.save(postOffice);

        return postOfficeRespMapper.toPostOfficeResp(save);
    }

    @Override
    public PostOffice read(String index) {

        return postOfficeRepository.findByIndex(index).orElseThrow(() -> new PostOfficeNotFound());
    }
}
