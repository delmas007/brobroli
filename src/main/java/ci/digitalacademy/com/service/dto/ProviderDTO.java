package ci.digitalacademy.com.service.dto;

import ci.digitalacademy.com.model.AddInformation;
import ci.digitalacademy.com.model.Service;
import ci.digitalacademy.com.model.Skills;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProviderDTO extends PersonDTO{
    private Set<Skills> skills;
    private Set<AddInformation> addInformation;
    @JsonIgnore
    private Set<Service> service;
}
