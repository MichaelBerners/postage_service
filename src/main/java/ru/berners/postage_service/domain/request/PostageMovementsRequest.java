package ru.berners.postage_service.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.entity.Postage;

@Data
public class PostageMovementsRequest {
    @NotEmpty
    @Schema(description = "индекс почтового отделения", example = "236040")
    private String indexPostOffice;
    @NotNull
    @Schema(description = "идентификатор почтового отправления", example = "1")
    private Long postageId;
}
