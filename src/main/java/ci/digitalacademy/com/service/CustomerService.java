package ci.digitalacademy.com.service;

import ci.digitalacademy.com.service.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    //Enregitrer un client
    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    CustomerDTO save(CustomerDTO customerDTO);

    //La liste des Forums
    List<CustomerDTO> findAllcustomer();

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    // Modification d'un client existant
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);

    // Recherche d'un client par son ID
    Optional<CustomerDTO> findOneCustomer(Long id);

    // Recherche d'un client par son slug
    Optional<CustomerDTO> getCustomerBySlug(String slug);


}
