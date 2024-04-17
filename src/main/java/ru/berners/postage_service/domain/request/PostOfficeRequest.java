package ru.berners.postage_service.domain.request;

import lombok.Data;

@Data
public class PostOfficeRequest {
    private String index;
    private String name;
    private String address;
}
