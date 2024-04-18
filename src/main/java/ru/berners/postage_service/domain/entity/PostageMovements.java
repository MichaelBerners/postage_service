package ru.berners.postage_service.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "postage_movements")
public class PostageMovements {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postage_movements_id_seq")
    @SequenceGenerator(name = "postage_movements_id_seq", allocationSize = 1)
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
    @Column(name = "created_at")
    private Timestamp createdAt;

}
