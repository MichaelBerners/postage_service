package ru.berners.postage_service.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "post_offices")
public class PostOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_offices_id_seq")
    @SequenceGenerator(name = "post_offices_id_seq", allocationSize = 1)
    private Long id;
    private String index;
    private String name;
    private String address;
}
