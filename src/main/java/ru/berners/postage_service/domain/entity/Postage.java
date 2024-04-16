package ru.berners.postage_service.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "postages")
public class Postage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_name")
    @SequenceGenerator(name = "seq_name", allocationSize = 1)
    private Long id;
    @Column(name = "recipient_name")
    private String recipientName;
    @Enumerated(EnumType.STRING)
    @Column(name = "postage_type")
    private PostageType postageType;
    @Column(name = "sender_index")
    private String senderIndex; //?
    @Column(name = "recipient_index")
    private String recipientIndex;
    @Column(name = "recipient_address")
    private String recipientAddress;
    @Enumerated(EnumType.STRING)
    @Column(name = "postage_status")
    private PostageStatus postageStatus;

}
