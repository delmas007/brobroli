package ci.digitalacademy.com.repository;

import ci.digitalacademy.com.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service,Long> {
    Optional<Service> findBySlug(String slug);
}
