package ru.berners.postage_service.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "postage_movements")
public class PostageMovements {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_name")
    @SequenceGenerator(name = "seq_name", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "post_office_id")
    private PostOffice postOffice;
    @ManyToOne
    @JoinColumn(name = "postage_id")
    private Postage postage;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "postage_movement_status")
    private PostageMovementStatus postageMovementStatus;
    @Column(name = "date_time")
    private Timestamp dateTime;

}
