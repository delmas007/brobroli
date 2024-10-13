package ci.digitalacademy.com.service;

import ci.digitalacademy.com.service.dto.CollaborationDTO;

import java.util.Optional;

public interface CollaborationService {
    CollaborationDTO save(Long id_service,Long id_customer);
    CollaborationDTO save(CollaborationDTO collaborationDTO);
    Optional<CollaborationDTO> findOne(Long id);
    void accept(Long id_collaboration);
    void reject(Long id_collaboration);
    void annuler(Long id_collaboration);
    void CompleteProvider(Long id_collaboration);
    void CompleteCustomer(Long id_collaboration);
}
