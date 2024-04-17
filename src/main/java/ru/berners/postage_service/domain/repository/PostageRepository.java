package ru.berners.postage_service.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.berners.postage_service.domain.entity.Postage;

import java.util.List;

public interface PostageRepository extends JpaRepository<Postage, Long> {



}
