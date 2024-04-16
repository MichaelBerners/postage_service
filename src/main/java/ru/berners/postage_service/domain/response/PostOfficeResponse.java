package ru.berners.postage_service.domain.response;

import lombok.Data;

@Data
public class PostOfficeResponse {

    private String index;
    private String name;
    private String address;
}
