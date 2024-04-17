package ru.berners.postage_service.domain.response;

import lombok.Data;
import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.entity.Postage;

import java.sql.Timestamp;

@Data
public class PostageMovementsResponse {

    private String postOfficeIndex;
    private Long postageId;
    private String status;
    private Timestamp timestamp;


}
