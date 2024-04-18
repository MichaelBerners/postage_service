package ru.berners.postage_service.domain.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.entity.Postage;

@Data
public class PostageMovementsRequest {
    @NotEmpty
    private String indexPostOffice;
    @NotNull
    private Long postageId;
}
