package ru.berners.postage_service.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "postages")
public class Postage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postages_id_seq")
    @SequenceGenerator(name = "postages_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "recipient_name")
    private String recipientName;
    @Enumerated(EnumType.STRING)
    @Column(name = "postage_type")
    private PostageType postageType;
    @Column(name = "sender_index")
    private String senderIndex;
    @Column(name = "recipient_index")
    private String recipientIndex;
    @Column(name = "recipient_address")
    private String recipientAddress;
    @Enumerated(EnumType.STRING)
    @Column(name = "postage_status")
    private PostageStatus postageStatus;
    @OneToMany(mappedBy = "postage")
    private List<PostageMovements> postageMovements;

}
