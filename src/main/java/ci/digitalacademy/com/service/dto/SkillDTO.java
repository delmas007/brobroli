package ci.digitalacademy.com.service.dto;

import ci.digitalacademy.com.model.Provider;
import ci.digitalacademy.com.model.enume.SkillLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillDTO {

    private Long id;
    private String skillName;
    private SkillLevel skillLevel;
    private String slug;
    private Provider provider;
}