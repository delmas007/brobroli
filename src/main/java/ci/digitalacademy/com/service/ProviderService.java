package ci.digitalacademy.com.service;

import ci.digitalacademy.com.service.dto.ProviderDTO;

import java.util.List;
import java.util.Optional;

public interface ProviderService {

    ProviderDTO save( ProviderDTO  providerDTO);
    ProviderDTO saveProvider( ProviderDTO  providerDTO);

    ProviderDTO update( ProviderDTO  providerDTO);

    Optional< ProviderDTO> findOneById(Long id);

    Optional< ProviderDTO> findOneBySlug(String slug);

    List< ProviderDTO> findAll();

    ProviderDTO update( ProviderDTO  providerDTO, Long id);

}
