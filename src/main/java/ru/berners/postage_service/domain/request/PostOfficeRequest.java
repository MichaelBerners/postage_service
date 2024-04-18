package ru.berners.postage_service.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PostOfficeRequest {
    @NotEmpty
    @Schema(description = "индекс почтового отделения", example = "238725")
    private String index;
    @NotEmpty
    @Schema(description = "название почтового отделения", example = "Почтовое отделение №238725")
    private String name;
    @NotEmpty
    @Schema(description = "адрес почтового отделения", example = "край Приморский, г Владивосток, ул Воропаева, дом 22")
    private String address;
}
