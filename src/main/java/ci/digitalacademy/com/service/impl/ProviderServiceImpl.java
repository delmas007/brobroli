package ci.digitalacademy.com.service.impl;

import ci.digitalacademy.com.model.Provider;
import ci.digitalacademy.com.model.Role;
import ci.digitalacademy.com.repository.ProviderRepository;
import ci.digitalacademy.com.security.AuthorityConstants;
import ci.digitalacademy.com.service.ProviderService;
import ci.digitalacademy.com.service.dto.PersonDTO;
import ci.digitalacademy.com.service.dto.ProviderDTO;
import ci.digitalacademy.com.service.dto.RoleDTO;
import ci.digitalacademy.com.service.mapper.ProviderMapper;
import ci.digitalacademy.com.utils.SlugifyUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;


    @Override
    public ProviderDTO saveProvider(ProviderDTO providerDTO) {
        RoleDTO role2 = new RoleDTO();
        role2.setRole(AuthorityConstants.PROVIDER);
        providerDTO.getUser().setRole(role2);
        providerDTO.setCreateAt(LocalDate.now());
        providerDTO.setSlug(SlugifyUtils.generate( providerDTO.getLastName()));
        Provider provider = providerMapper.toEntity( providerDTO);
        return providerMapper.fromEntity(providerRepository.save(provider));
    }

    @Override
    public ProviderDTO save(ProviderDTO providerDTO) {
        Provider provider = providerMapper.toEntity( providerDTO);
        return providerMapper.fromEntity(providerRepository.save(provider));

    }

    @Override
    public ProviderDTO update(ProviderDTO providerDTO) {
        return findOneById(providerDTO.getId()).map(existingProvider ->{
            existingProvider.setUpdateAt(LocalDate.now());
            if (providerDTO.getBalance() != null){
                existingProvider.setBalance(providerDTO.getBalance());
            }
            if (providerDTO.getBiographie() != null){
                existingProvider.setBiographie(providerDTO.getBiographie());
            }
            if (providerDTO.getEmail() != null){
                existingProvider.setEmail(providerDTO.getEmail());
            }
            if (providerDTO.getFirstName() != null){
                existingProvider.setFirstName(providerDTO.getFirstName());
            }
            if (providerDTO.getLastName() != null){
                existingProvider.setLastName(providerDTO.getLastName());
            }
            if (providerDTO.getCity() != null){
                existingProvider.setCity(providerDTO.getCity());
            }
            if (providerDTO.getStreet() != null){
                existingProvider.setStreet(providerDTO.getStreet());
            }

            if (providerDTO.getUrlProfil() != null){
                existingProvider.setUrlProfil(providerDTO.getUrlProfil());
            }

            if (providerDTO.getSlug() != null){
                existingProvider.setSlug(providerDTO.getSlug());
            }

            if (providerDTO.getTel() != null){
                existingProvider.setTel(providerDTO.getTel());
            }

            return save(existingProvider);
        }).orElse(null);

    }

    @Override
    public Optional<ProviderDTO> findOneById(Long id) {
        return providerRepository.findById(id).map(provider ->{
            return providerMapper.fromEntity(provider);
        });

    }

    @Override
    public Optional<ProviderDTO> findOneBySlug(String slug) {
        return providerRepository.findBySlug(slug).map(provider ->{
            return providerMapper.fromEntity(provider);
        });

    }

    @Override
    public List<ProviderDTO> findAll() {
        return providerRepository.findAll().stream().map(provider -> providerMapper.fromEntity(provider)).toList();

    }

    @Override
    public ProviderDTO update(ProviderDTO providerDTO, Long id) {
        providerDTO.setId(id);
        return update(providerDTO);

    }

}
