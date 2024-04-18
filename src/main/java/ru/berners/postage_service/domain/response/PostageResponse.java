package ru.berners.postage_service.domain.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.berners.postage_service.domain.entity.PostageStatus;
import ru.berners.postage_service.domain.entity.PostageType;

@Data
public class PostageResponse {

    @Schema(description = "ФИО получателя", example = "Иванов Иван Иванович")
    private String recipientName;
    @Schema(description = "тип почтового отправления", example = "LATTER, PACKAGE, PARCEL, POSTCARD")
    private PostageType postageType;
    @Schema(description = "индекс отправителя", example = "238725")
    private String senderIndex;
    @Schema(description = "индекс получателя", example = "238725")
    private String recipientIndex;
    @Schema(description = "адрес получателя", example = "край Приморский, г Владивосток, ул Воропаева, дом 22")
    private String recipientAddress;
    @Schema(description = "статус отправления", example = "REGISTERED, INTERMEDIATE_POST_OFFICE, MOVEMENT, DELIVERED, RECEIVED")
    private PostageStatus postageStatus;
}
