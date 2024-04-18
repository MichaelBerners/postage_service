package ru.berners.postage_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.berners.postage_service.domain.entity.*;
import ru.berners.postage_service.domain.exception.PostageMovementException;
import ru.berners.postage_service.domain.mapper.PostageMovementsRespMapper;
import ru.berners.postage_service.domain.repository.PostageMovementsRepository;
import ru.berners.postage_service.domain.request.PostageMovementsRequest;
import ru.berners.postage_service.domain.response.PostageMovementsResponse;
import ru.berners.postage_service.service.PostOfficeService;
import ru.berners.postage_service.service.PostageMovementsService;
import ru.berners.postage_service.service.PostageService;

import java.sql.Timestamp;


@Service
@AllArgsConstructor
public class PostageMovementsServiceImpl implements PostageMovementsService {

    private final PostageMovementsRepository postageMovementsRepository;
    private final PostOfficeService postOfficeService;
    private final PostageService postageService;
    private final PostageMovementsRespMapper postageMovementsRespMapper;

    @Override
    public PostageMovementsResponse createRegistration(PostageMovementsRequest postageMovementsRequest) {
        String indexPostOffice = postageMovementsRequest.getIndexPostOffice();
        Long postageId = postageMovementsRequest.getPostageId();
        Postage postage = postageService.read(postageId);
        if(postage.getSenderIndex().equals(indexPostOffice)
                && postage.getPostageStatus().equals(PostageStatus.REGISTERED)) {
            PostOffice postOffice = postOfficeService.read(indexPostOffice);
            PostageMovements postageMovements = new PostageMovements();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            postageMovements.setPostOffice(postOffice);
            postageMovements.setPostage(postage);
            postageMovements.setPostageMovementStatus(PostageMovementStatus.ARRIVED_AT_THE_POST_OFFICE);
            postageMovements.setCreatedAt(timestamp);
            PostageMovements savePostageMovements = postageMovementsRepository.save(postageMovements);

            return postageMovementsRespMapper.toPostageMovementsResp(savePostageMovements);
        }

        throw new PostageMovementException();
    }

    @Transactional
    @Override
    public PostageMovementsResponse createArrival(PostageMovementsRequest postageMovementsRequest) {
        String indexPostOffice = postageMovementsRequest.getIndexPostOffice();
        Long postageId = postageMovementsRequest.getPostageId();
        Postage postage = postageService.read(postageId);
        PostOffice postOffice = postOfficeService.read(indexPostOffice);
        PostageMovements postageMovements = new PostageMovements();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        postageMovements.setPostOffice(postOffice);
        postageMovements.setPostage(postage);
        postageMovements.setCreatedAt(timestamp);
        if (postage.getPostageStatus().equals(PostageStatus.MOVEMENT)) {
            if (postage.getRecipientIndex().equals(indexPostOffice)) {
                postageService.updateStatus(postageId, PostageStatus.DELIVERED);
                postageMovements.setPostageMovementStatus(PostageMovementStatus.ARRIVED_AT_THE_POST_OFFICE);
                PostageMovements saveDelivered = postageMovementsRepository.save(postageMovements);

                return postageMovementsRespMapper
                        .toPostageMovementsResp(saveDelivered);
            }
            postageService.updateStatus(postageId, PostageStatus.INTERMEDIATE_POST_OFFICE);
            postageMovements.setPostageMovementStatus(PostageMovementStatus.ARRIVED_AT_THE_POST_OFFICE);
            PostageMovements saveIntermediatePostOffice = postageMovementsRepository.save(postageMovements);

            return postageMovementsRespMapper
                    .toPostageMovementsResp(saveIntermediatePostOffice);
        }

        throw new PostageMovementException();
    }

    @Transactional
    @Override
    public PostageMovementsResponse createDeparture(PostageMovementsRequest postageMovementsRequest) {
        String indexPostOffice = postageMovementsRequest.getIndexPostOffice();
        Long postageId = postageMovementsRequest.getPostageId();
        Postage postage = postageService.read(postageId);
        PostOffice postOffice = postOfficeService.read(indexPostOffice);
        PostageMovements postageMovements = new PostageMovements();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        postageMovements.setPostOffice(postOffice);
        postageMovements.setPostage(postage);
        postageMovements.setCreatedAt(timestamp);
        if (!postage.getPostageStatus().equals(PostageStatus.MOVEMENT)) {
            if(postage.getPostageStatus().equals(PostageStatus.DELIVERED)
                    && postage.getRecipientIndex().equals(indexPostOffice)) {
                postageService.updateStatus(postageId, PostageStatus.RECEIVED);
                postageMovements.setPostageMovementStatus(PostageMovementStatus.HAS_LEFT_THE_POST_OFFICE);
                PostageMovements saveReceived = postageMovementsRepository.save(postageMovements);
                PostageMovementsResponse resultReceived = postageMovementsRespMapper
                        .toPostageMovementsResp(saveReceived);

                return resultReceived;
            }
            postageService.updateStatus(postageId, PostageStatus.MOVEMENT);
            postageMovements.setPostageMovementStatus(PostageMovementStatus.HAS_LEFT_THE_POST_OFFICE);
            PostageMovements saveMovement = postageMovementsRepository.save(postageMovements);

            return postageMovementsRespMapper
                    .toPostageMovementsResp(saveMovement);
        }

        throw new PostageMovementException();
    }
}
