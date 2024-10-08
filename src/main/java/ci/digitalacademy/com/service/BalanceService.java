package ci.digitalacademy.com.service;

import ci.digitalacademy.com.service.dto.BalanceDTO;
import ci.digitalacademy.com.service.dto.ProviderDTO;
import ci.digitalacademy.com.service.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface BalanceService {
    BalanceDTO save(BalanceDTO balanceDTO,Long id);
    BalanceDTO update(BalanceDTO balanceDTO, ProviderDTO providerDTO);
    BalanceDTO update(BalanceDTO balanceDTO,Long id);
    List<BalanceDTO> findAll();
    Optional<BalanceDTO> getById(Long id);
    Optional<BalanceDTO> getBySlug(String slug);
}
