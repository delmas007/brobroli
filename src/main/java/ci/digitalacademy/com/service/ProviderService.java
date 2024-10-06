package ci.digitalacademy.com.service;

import ci.digitalacademy.com.service.dto.ProviderDTO;

import java.util.List;
import java.util.Optional;

public interface ProviderService {

    ProviderDTO save( ProviderDTO  providerDTO);

    ProviderDTO update( ProviderDTO  providerDTO);

    Optional< ProviderDTO> findOneById(Long id);

    List< ProviderDTO> findAll();

    ProviderDTO update( ProviderDTO  providerDTO, Long id);

    ProviderDTO partialUpdate( ProviderDTO  providerDTO, Long id);
}
