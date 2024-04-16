package ru.berners.postage_service.domain.request;

import lombok.Data;
import ru.berners.postage_service.domain.entity.PostOffice;
import ru.berners.postage_service.domain.entity.Postage;

@Data
public class PostageMovementsRequest {
    private PostOffice postOffice;
    private Postage postage;
}
