package ci.digitalacademy.com.web.resources;


import ci.digitalacademy.com.service.BalanceService;
import ci.digitalacademy.com.service.CollaborationService;
import ci.digitalacademy.com.service.CustomerService;
import ci.digitalacademy.com.service.dto.BalanceDTO;
import ci.digitalacademy.com.service.dto.CollaborationDTO;
import ci.digitalacademy.com.service.dto.CustomerDTO;
import ci.digitalacademy.com.service.dto.FileCustomerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerResource {

   private final CustomerService customerService;
   private final CollaborationService collaborationService;
   private final BalanceService balanceService;

   @PostMapping
   @ApiResponse(responseCode = "201", description = "Request to save customer")
   @Operation(summary = "save new customer", description = "This endpoint allow to save customer")
   public ResponseEntity<CustomerDTO> saveCustomer(@ModelAttribute FileCustomerDTO customerDTO) throws IOException {
        log.debug("REST, Request to save Customer : {}", customerDTO);
        return new ResponseEntity<>(customerService.saveCustomer(customerDTO), HttpStatus.CREATED);
   }

    @PutMapping("/collaboration/annuler/{id_collaboration}")
    public void aannuleCollaboration(@PathVariable long id_collaboration) {
        log.debug("REST, Request to annule Collaboration : {}", id_collaboration);
        collaborationService.annuler(id_collaboration);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@ModelAttribute FileCustomerDTO customerDTO, @PathVariable long id) throws IOException {
        log.debug("REST, Request to update Customer : {}", customerDTO, id);
        return new ResponseEntity<>(customerService.updateCustomer(id, customerDTO), HttpStatus.OK);
    }

  @GetMapping
  public List<CustomerDTO> getAllCustomers() {
      log.debug("REST, Request to get all customers");
      return customerService.findAllcustomer();
  }

   @GetMapping("/id/{id}")
   public ResponseEntity<?> getCustomers(@PathVariable long id) {
       log.debug("REST, Request to get Customers : {}", id);
       Optional<CustomerDTO>customerDTO =customerService.findOneCustomer(id);
       if (customerDTO.isPresent()) {
           return new ResponseEntity<>(customerDTO.get(), HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }

   @GetMapping("/slug/{slug}")
   public ResponseEntity<?> getCustomerBySlug(@PathVariable String slug) {
       log.debug("REST, Request to get Customer : {}", slug);
       Optional<CustomerDTO> customer =customerService.getCustomerBySlug(slug);
       if (customer.isPresent()) {
           return new ResponseEntity<>(customer.get(), HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }

    @PostMapping("/balance/{id}")
    public ResponseEntity<?> saveBalance(@RequestBody BalanceDTO balanceDTO, @PathVariable long id) {
        log.debug("REST, Request to save Balance : {} {}", balanceDTO, id);
        return new ResponseEntity<>(balanceService.save(balanceDTO, id), HttpStatus.CREATED);
    }

    @PostMapping("/collaboration/{id_service}/{id_customer}")
    public CollaborationDTO saveCollaboration(@PathVariable long id_service, @PathVariable long id_customer) {
        log.debug("REST, Request to save Collaboration : {} {} ", id_service, id_customer);
        return collaborationService.save(id_service, id_customer);
    }

    @PutMapping("/collaboration/terminer/{id_collaboration}")
    public void terminerCollaboration(@PathVariable long id_collaboration) {
        log.debug("REST, Request to terminer Collaboration : {} ", id_collaboration);
        collaborationService.CompleteCustomer(id_collaboration);
    }

}
