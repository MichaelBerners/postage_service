package ru.berners.postage_service.domain.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PostOfficeRequest {
    @NotEmpty
    private String index;
    @NotEmpty
    private String name;
    @NotEmpty
    private String address;
}
