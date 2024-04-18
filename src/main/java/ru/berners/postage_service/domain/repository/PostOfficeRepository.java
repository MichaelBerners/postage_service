package ru.berners.postage_service.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.berners.postage_service.domain.entity.PostOffice;

import java.util.Optional;

public interface PostOfficeRepository extends JpaRepository<PostOffice, Long> {

    Optional<PostOffice> findByIndex(String index);
}