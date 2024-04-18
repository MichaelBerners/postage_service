package ru.berners.postage_service.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.berners.postage_service.domain.entity.*;
import ru.berners.postage_service.domain.exception.PostageNotFoundException;
import ru.berners.postage_service.domain.mapper.PostageMovementsRespMapper;
import ru.berners.postage_service.domain.mapper.PostageRespMapper;
import ru.berners.postage_service.domain.repository.PostageRepository;
import ru.berners.postage_service.domain.request.PostageRequest;
import ru.berners.postage_service.domain.response.PostageMovementsResponse;
import ru.berners.postage_service.domain.response.PostageResponse;
import ru.berners.postage_service.service.PostageService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostageServiceImpl implements PostageService {

    private final PostageRepository postageRepository;
    private final PostageRespMapper postageRespMapper;
    private final PostageMovementsRespMapper postageMovementsRespMapper;

    @Override
    public PostageResponse create(PostageRequest postageRequest) {
        Postage postage = new Postage();
        postage.setRecipientName(postageRequest.getRecipientName());
        postage.setPostageType(postageRequest.getPostageType());
        postage.setSenderIndex(postageRequest.getSenderIndex());
        postage.setRecipientIndex(postageRequest.getRecipientIndex());
        postage.setRecipientAddress(postageRequest.getRecipientAddress());
        postage.setPostageStatus(PostageStatus.REGISTERED);
        Postage savePostage = postageRepository.save(postage);

        return postageRespMapper.toPostageResp(savePostage);
    }

    @Override
    public Postage read(Long id) {

        return postageRepository.findById(id).orElseThrow(PostageNotFoundException::new);
    }

    @Override
    public PostageStatus findPostageStatus(Long id) {
        Postage postage = read(id);

        return postage.getPostageStatus();
    }

    @Override
    public PostageResponse updateStatus(Long id, PostageStatus postageStatus) {
        Postage postage = read(id);
        postage.setPostageStatus(postageStatus);
        Postage updatePostage = postageRepository.save(postage);

        return postageRespMapper.toPostageResp(updatePostage);
    }

    @Override
    public List<PostageMovementsResponse> readHistoryMovements(Long id) {
        Postage postage = postageRepository.findById(id).orElseThrow(PostageNotFoundException::new);
        List<PostageMovements> postageMovements = postage.getPostageMovements();

        return postageMovements.stream()
                .map(postageMovementsRespMapper::toPostageMovementsResp)
                .collect(Collectors.toList());
    }
}
