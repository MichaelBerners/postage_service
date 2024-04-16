package ru.berners.postage_service.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.berners.postage_service.domain.entity.PostageMovements;

public interface PostageMovementsRepository extends JpaRepository<PostageMovements, Long> {
}
