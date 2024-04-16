package ru.berners.postage_service.domain.request;

import lombok.Data;

@Data
public class PostageRequest {

    private String recipientName;
    private String postageType;
    private String senderIndex;
    private String recipientIndex;
    private String recipientAddress;

}
