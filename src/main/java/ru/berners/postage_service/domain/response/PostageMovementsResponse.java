package ru.berners.postage_service.domain.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.entity.Postage;

import java.sql.Timestamp;

@Data
public class PostageMovementsResponse {

    @Schema(description = "индекс почтового отделения", example = "238725")
    private String postOfficeIndex;
    @Schema(description = "идентификатор почтового отправления", example = "77")
    private Long postageId;
    @Schema(description = "статус передвижения", example = "HAS_LEFT_THE_POST_OFFICE, ARRIVED_AT_THE_POST_OFFICE")
    private String status;
    @Schema(description = "дата и время создания")
    private Timestamp createdAt;


}
