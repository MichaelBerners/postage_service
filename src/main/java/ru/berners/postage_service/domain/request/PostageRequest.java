package ru.berners.postage_service.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.berners.postage_service.domain.entity.PostageType;

@Data
public class PostageRequest {

    @NotEmpty
    @Schema(description = "ФИО получателя", example = "Иванов Иван Иванович")
    private String recipientName;
    @NotNull
    @Schema(description = "тип почтового отправления", example = "LATTER")
    private PostageType postageType;
    @NotEmpty
    @Schema(description = "индекс отправителя", example = "236040")
    private String senderIndex;
    @NotEmpty
    @Schema(description = "индекс получателя", example = "915815")
    private String recipientIndex;
    @NotEmpty
    @Schema(description = "адрес получателя", example = "край Приморский, г Владивосток, ул Воропаева, дом 22")
    private String recipientAddress;
}
