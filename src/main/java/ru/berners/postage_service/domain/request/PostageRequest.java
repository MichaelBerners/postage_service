package ru.berners.postage_service.domain.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PostageRequest {

    @NotEmpty
    private String recipientName;
    @NotEmpty
    private String postageType;
    @NotEmpty
    private String senderIndex;
    @NotEmpty
    private String recipientIndex;
    @NotEmpty
    private String recipientAddress;

}
