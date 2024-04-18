package ru.berners.postage_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.exception.PostOfficeNotFound;
import ru.berners.postage_service.domain.mapper.PostOfficeRespMapper;
import ru.berners.postage_service.domain.repository.PostOfficeRepository;
import ru.berners.postage_service.domain.request.PostOfficeRequest;
import ru.berners.postage_service.domain.response.PostOfficeResponse;
import ru.berners.postage_service.service.PostOfficeService;

@Service
@AllArgsConstructor
public class PostOfficeServiceImpl implements PostOfficeService {

    private final PostOfficeRepository postOfficeRepository;
    private final PostOfficeRespMapper postOfficeRespMapper;

    @Override
    public PostOfficeResponse create(PostOfficeRequest postOfficeRequest) {
        PostOffice postOffice = new PostOffice();
        postOffice.setIndex(postOfficeRequest.getIndex());
        postOffice.setName(postOfficeRequest.getName());
        postOffice.setName(postOfficeRequest.getAddress());
        PostOffice save = postOfficeRepository.save(postOffice);
        PostOfficeResponse result = postOfficeRespMapper.toPostOfficeResp(save);

        return result;
    }

    @Override
    public PostOffice read(String index) {
        return postOfficeRepository.findPostOfficesByIndex(index).orElseThrow(() -> new PostOfficeNotFound());

    }


}
