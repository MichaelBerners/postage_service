package ru.berners.postage_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.berners.postage_service.domain.entity.*;
import ru.berners.postage_service.domain.mapper.PostageMovementsRespMapper;
import ru.berners.postage_service.domain.mapper.PostageRespMapper;
import ru.berners.postage_service.domain.repository.PostageRepository;
import ru.berners.postage_service.domain.request.PostageRequest;
import ru.berners.postage_service.domain.response.PostageMovementsResponse;
import ru.berners.postage_service.domain.response.PostageResponse;
import ru.berners.postage_service.service.PostageMovementsService;
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
        postage.setPostageType(PostageType.valueOf(postageRequest.getPostageType()));
        postage.setSenderIndex(postageRequest.getSenderIndex());
        postage.setRecipientIndex(postageRequest.getRecipientIndex());
        postage.setRecipientAddress(postageRequest.getRecipientAddress());
        postage.setPostageStatus(PostageStatus.REGISTERED);
        Postage savePostage = postageRepository.save(postage);
        PostageResponse result = postageRespMapper.toPostageResp(savePostage);

        return result;
    }

    @Override
    public Postage read(Long id) {
        return postageRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public String readPostageStatus(Long id) {
        Postage postage = read(id);
        String result = postage.getPostageStatus().name();

        return result;
    }

    @Override
    public PostageResponse updateStatus(Long id, PostageStatus postageStatus) {
        Postage postage = read(id);
        postage.setPostageStatus(postageStatus);
        Postage updatePostage = postageRepository.save(postage);
        PostageResponse result = postageRespMapper.toPostageResp(updatePostage);

        return result;
    }

    @Override
    public List<PostageMovementsResponse> readHistoryMovements(Long id) {
        Postage postage = postageRepository.findById(id).orElseThrow(() -> new RuntimeException());
        List<PostageMovements> postageMovements = postage.getPostageMovements();
        List<PostageMovementsResponse> result = postageMovements.stream()
                .map($ -> postageMovementsRespMapper.toPostageMovementsResp($))
                .collect(Collectors.toList());

        return result;
    }


}
