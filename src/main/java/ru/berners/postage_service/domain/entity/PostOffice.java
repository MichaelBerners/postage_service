package ru.berners.postage_service.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "post_offices")
public class PostOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_name")
    @SequenceGenerator(name = "seq_name", allocationSize = 1)
    private Long id;
    private String index;
    private String name;
    private String address;
}
