package ru.berners.postage_service.domain.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PostOfficeResponse {

    @Schema(description = "индекс почтового отделения", example = "238725")
    private String index;
    @Schema(description = "название почтового отделения", example = "Почтовое отделение №238725")
    private String name;
    @Schema(description = "адрес почтового отделения", example = "край Приморский, г Владивосток, ул Воропаева, дом 22")
    private String address;
}
