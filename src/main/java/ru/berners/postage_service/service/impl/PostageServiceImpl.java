package ru.berners.postage_service.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.entity.Postage;
import ru.berners.postage_service.domain.entity.PostageStatus;
import ru.berners.postage_service.domain.entity.PostageType;
import ru.berners.postage_service.domain.repository.PostageRepository;
import ru.berners.postage_service.domain.request.PostageRequest;
import ru.berners.postage_service.domain.response.PostOfficeResponse;
import ru.berners.postage_service.domain.response.PostageMovementsResponse;
import ru.berners.postage_service.domain.response.PostageResponse;
import ru.berners.postage_service.service.PostOfficeService;
import ru.berners.postage_service.service.PostageMovementsService;
import ru.berners.postage_service.service.PostageService;

import java.util.List;

@Service
@AllArgsConstructor
public class PostageServiceImpl implements PostageService {

    private final PostageRepository postageRepository;
    private final PostageMovementsService postageMovementsService;
    private final PostOfficeService postOfficeService;
    @Override
    public PostageResponse create(PostageRequest postageRequest) {
        Postage postage = new Postage();
        postage.setRecipientName(postageRequest.getRecipientName());
        postage.setPostageType(PostageType.valueOf(postageRequest.getPostageType()));
        postage.setSenderIndex(postageRequest.getSenderIndex());
        postage.setRecipientIndex(postageRequest.getRecipientIndex());
        postage.setRecipientAddress(postageRequest.getRecipientAddress());
        postage.setPostageStatus(PostageStatus.REGISTERED);
        Postage save = postageRepository.save(postage);

        PostOffice postOffice = postOfficeService.read(postage.getSenderIndex());


        postageMovementsService.create(postOffice ,postage);


        return null;
    }

    @Override
    public PostageResponse updateStatus(Long id, PostageStatus postageStatus) {
        Postage postage = postageRepository.findById(id).orElseThrow(() -> new RuntimeException());
        postage.setPostageStatus(postageStatus);
        postageRepository.save(postage);
        return null;

    }

    @Override
    public List<PostageMovementsResponse> readHistoryMovements(String index) {
        return null;
    }

    @Override
    public void departureFromThePostOffice(PostOffice postOffice) {


    }

    @Override
    public void arrivalFromThePostOffice(PostOffice postOffice) {

    }
}
