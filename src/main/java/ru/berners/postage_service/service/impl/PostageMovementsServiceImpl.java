package ru.berners.postage_service.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.berners.postage_service.domain.entity.*;
import ru.berners.postage_service.domain.repository.PostageMovementsRepository;
import ru.berners.postage_service.domain.request.PostageMovementsRequest;
import ru.berners.postage_service.domain.response.PostageMovementsResponse;
import ru.berners.postage_service.service.PostageMovementsService;

import java.sql.Timestamp;

@Service
@AllArgsConstructor
public class PostageMovementsServiceImpl implements PostageMovementsService {

    private final PostageMovementsRepository postageMovementsRepository;
    @Override
    public PostageMovementsResponse create(PostOffice postOffice, Postage postage) {

        if(postage.getSenderIndex().equals(postOffice.getIndex())
                && postage.getPostageStatus().equals(PostageStatus.REGISTERED)) {

            PostageMovements postageMovements = new PostageMovements();
            postageMovements.setPostOffice(postOffice);
            postageMovements.setPostage(postage);
            postageMovements.setPostageMovementStatus(PostageMovementStatus.ARRIVED_AT_THE_POST_OFFICE);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            postageMovements.setDateTime(timestamp);

            postageMovementsRepository.save(postageMovements);
            return new PostageMovementsResponse();

        }
        if(!postage.getSenderIndex().equals(postOffice.getIndex())
                && !postage.getRecipientIndex().equals(postOffice.getIndex())
                && postage.getPostageStatus().equals(PostageStatus.REGISTERED)) {

        }
        return null;
    }
}
