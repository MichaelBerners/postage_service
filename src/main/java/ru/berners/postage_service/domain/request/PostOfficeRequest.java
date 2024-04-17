package ru.berners.postage_service.domain.request;

import lombok.Data;

@Data
public class PostOfficeRequest {
    private String oldIndex;
    private String newIndex;
    private String name;
    private String address;
}
