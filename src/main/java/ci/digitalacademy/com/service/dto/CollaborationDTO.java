package ci.digitalacademy.com.service.dto;

import ci.digitalacademy.com.model.Customer;
import ci.digitalacademy.com.model.Feedback;
import ci.digitalacademy.com.model.InterimBalance;
import ci.digitalacademy.com.model.Service;
import ci.digitalacademy.com.model.enume.CollaborationStatus;
import java.time.LocalDate;
import java.util.Set;

public class CollaborationDTO {
    private Long id;
    private String slug;
    private CollaborationStatus status;
    private LocalDate createAt;
    private LocalDate updateAt;
    private Service service;
    private Customer customer;
    private InterimBalance interimBalance;
    private Set<Feedback> feedback;
}
