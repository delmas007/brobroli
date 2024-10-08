package ci.digitalacademy.com.repository;

import ci.digitalacademy.com.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skills, Long> {
}
