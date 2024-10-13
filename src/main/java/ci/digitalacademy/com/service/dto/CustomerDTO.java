package ci.digitalacademy.com.service.dto;

import ci.digitalacademy.com.model.Collaboration;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CustomerDTO extends PersonDTO{
    private Set<CollaborationDTO> collaboration;
}
