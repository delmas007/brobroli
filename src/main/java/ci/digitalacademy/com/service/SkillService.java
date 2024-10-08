package ci.digitalacademy.com.service;

import ci.digitalacademy.com.service.dto.SkillDTO;

import java.util.Optional;

public interface SkillService {

    SkillDTO save(SkillDTO skillDTO);

    SkillDTO saveskill(SkillDTO skillDTO);

    Optional<SkillDTO> findOneById(Long id);

    SkillDTO update(SkillDTO skillDTO, Long id);

    SkillDTO partialupdate(SkillDTO skillDTO);

}
