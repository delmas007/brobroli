package ci.digitalacademy.com.service.dto;

import ci.digitalacademy.com.model.Customer;
import ci.digitalacademy.com.model.Feedback;
import ci.digitalacademy.com.model.InterimBalance;
import ci.digitalacademy.com.model.Service;
import ci.digitalacademy.com.model.enume.CollaborationStatus;
import ci.digitalacademy.com.model.enume.CustomerStatusService;
import ci.digitalacademy.com.model.enume.ProviderStatusService;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
public class CollaborationDTO {
    private Long id;
    private String slug;
    private CollaborationStatus status;
    private LocalDate createAt;
    private LocalDate updateAt;
    private ServiceDTO service;
    private CustomerDTO customer;
    private InterimBalanceDTO interimBalance;
    private CustomerStatusService customerStatusService;
    private ProviderStatusService providerStatusService;
    private Set<FeedbackDTO> feedback;
}
