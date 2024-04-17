package ru.berners.postage_service.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.berners.postage_service.domain.entity.*;
import ru.berners.postage_service.domain.repository.PostageMovementsRepository;
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


    @Override
    public PostageMovementsResponse createRegistration(String indexPostOffice, Postage postage) {
        PostOffice postOffice = postOfficeService.read(indexPostOffice);
        PostageMovements postageMovements = new PostageMovements();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        postageMovements.setPostOffice(postOffice);
        postageMovements.setPostage(postage);
        postageMovements.setPostageMovementStatus(PostageMovementStatus.ARRIVED_AT_THE_POST_OFFICE);
        postageMovements.setDateTime(timestamp);
        PostageMovements savePostageMovements = postageMovementsRepository.save(postageMovements);

        return new PostageMovementsResponse();

    }

    @Override
    public PostageMovementsResponse createArrival(String indexPostOffice, Long postageId) {
        Postage postage = postageService.read(postageId);
        PostOffice postOffice = postOfficeService.read(indexPostOffice);
        PostageMovements postageMovements = new PostageMovements();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        postageMovements.setPostOffice(postOffice);
        postageMovements.setPostage(postage);
        postageMovements.setDateTime(timestamp);
        if (postage.getPostageStatus().equals(PostageStatus.MOVEMENT)) {
            if (postage.getRecipientIndex().equals(indexPostOffice)) {
                postageService.updateStatus(postageId, PostageStatus.DELIVERED);
                postageMovements.setPostageMovementStatus(PostageMovementStatus.ARRIVED_AT_THE_POST_OFFICE);
                PostageMovements saveDelivered = postageMovementsRepository.save(postageMovements);

                return new PostageMovementsResponse();
            }
            postageService.updateStatus(postageId, PostageStatus.INTERMEDIATE_POST_OFFICE);
            postageMovements.setPostageMovementStatus(PostageMovementStatus.ARRIVED_AT_THE_POST_OFFICE);
            PostageMovements saveIntermediatePostOffice = postageMovementsRepository.save(postageMovements);

            return new PostageMovementsResponse();
        }

        throw new RuntimeException();
    }

    @Override
    public PostageMovementsResponse createDeparture(String indexPostOffice, Long postageId) {
        Postage postage = postageService.read(postageId);
        PostOffice postOffice = postOfficeService.read(indexPostOffice);
        PostageMovements postageMovements = new PostageMovements();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        postageMovements.setPostOffice(postOffice);
        postageMovements.setPostage(postage);
        postageMovements.setDateTime(timestamp);
        if (!postage.getPostageStatus().equals(PostageStatus.MOVEMENT)) {
            if(postage.getPostageStatus().equals(PostageStatus.DELIVERED)
                    && postage.getRecipientIndex().equals(indexPostOffice)) {
                postageService.updateStatus(postageId, PostageStatus.RECEIVED);
                postageMovements.setPostageMovementStatus(PostageMovementStatus.HAS_LEFT_THE_POST_OFFICE);
                PostageMovements saveReceived = postageMovementsRepository.save(postageMovements);

                return new PostageMovementsResponse();
            }
            postageService.updateStatus(postageId, PostageStatus.MOVEMENT);
            postageMovements.setPostageMovementStatus(PostageMovementStatus.HAS_LEFT_THE_POST_OFFICE);
            PostageMovements saveMovement = postageMovementsRepository.save(postageMovements);

            return new PostageMovementsResponse();
        }

        throw new RuntimeException();
    }



}
