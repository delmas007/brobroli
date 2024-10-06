package ci.digitalacademy.com.repository;

import ci.digitalacademy.com.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
