package ru.berners.postage_service.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PostageRequest {

    @NotEmpty
    @Schema(description = "ФИО получателя", example = "Иванов Иван Иванович")
    private String recipientName;
    @NotEmpty
    @Schema(description = "тип почтового отправления", example = "LATTER, PACKAGE, PARCEL, POSTCARD")
    private String postageType;
    @NotEmpty
    @Schema(description = "индекс отправителя", example = "238725")
    private String senderIndex;
    @NotEmpty
    @Schema(description = "индекс получателя", example = "238725")
    private String recipientIndex;
    @NotEmpty
    @Schema(description = "адрес получателя", example = "край Приморский, г Владивосток, ул Воропаева, дом 22")
    private String recipientAddress;

}
