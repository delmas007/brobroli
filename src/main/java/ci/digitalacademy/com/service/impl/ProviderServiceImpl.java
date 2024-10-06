package ci.digitalacademy.com.service.impl;

import ci.digitalacademy.com.model.Provider;
import ci.digitalacademy.com.repository.ProviderRepository;
import ci.digitalacademy.com.service.ProviderService;
import ci.digitalacademy.com.service.dto.PersonDTO;
import ci.digitalacademy.com.service.dto.ProviderDTO;
import ci.digitalacademy.com.service.mapper.ProviderMapper;
import ci.digitalacademy.com.utils.SlugifyUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;


    @Override
    public ProviderDTO save(ProviderDTO providerDTO) {
        providerDTO.setSlug(SlugifyUtils.generate( providerDTO.getLastName()));
        Provider provider = providerMapper.toEntity( providerDTO);
        return providerMapper.fromEntity(providerRepository.save(provider));
    }

    @Override
    public ProviderDTO update(ProviderDTO providerDTO) {
        return null;
    }

    @Override
    public Optional<ProviderDTO> findOneById(Long id) {
        return providerRepository.findById(id).map(provider ->{
            return providerMapper.fromEntity(provider);
        });

    }

    @Override
    public List<ProviderDTO> findAll() {
        return providerRepository.findAll().stream().map(provider -> providerMapper.fromEntity(provider)).toList();

    }

    @Override
    public ProviderDTO update(ProviderDTO providerDTO, Long id) {

        return null;

    }

    @Override
    public ProviderDTO partialUpdate(ProviderDTO providerDTO, Long id) {
        return null;
    }
}
