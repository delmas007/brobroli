package ci.digitalacademy.com.service.dto;

import ci.digitalacademy.com.Views;
import ci.digitalacademy.com.model.Collaboration;
import ci.digitalacademy.com.model.Provider;
import ci.digitalacademy.com.model.enume.TypeService;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceDTO {
    private Long id;
    private TypeService typeService;
    private String description;
    private Float price;
    private Float duration;
    private String slug;
    @JsonView(Views.Internal.class)
    private ProviderDTO provider;
    private CollaborationDTO collaboration;
}
