package ru.berners.postage_service.domain.response;

import lombok.Data;
import ru.berners.postage_service.domain.entity.PostageStatus;

@Data
public class PostageResponse {

    private String recipientName;
    private String postageType;
    private String senderIndex;
    private String recipientIndex;
    private String recipientAddress;
    private String postageStatus;
}
