package ci.digitalacademy.com.web.resources;


import ci.digitalacademy.com.service.CustomerService;
import ci.digitalacademy.com.service.dto.CustomerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class CustomerResource {

   private final CustomerService customerService;

   @PostMapping
   @ApiResponse(responseCode = "201", description = "Request to save customer")
   @Operation(summary = "save new customer", description = "This endpoint allow to save customer")
   public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        log.debug("REST, Request to save Customer : {}", customerDTO);
        return new ResponseEntity<>(customerService.saveCustomer(customerDTO), HttpStatus.CREATED);
   }

  @GetMapping
  public List<CustomerDTO> getAllCustomers() {
      log.debug("REST, Request to get all customers");
      return customerService.findAllcustomer();
  }

   @PutMapping("/{id}")
   public ResponseEntity<?> updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable long id) {
       log.debug("REST, Request to update Customer : {}", customerDTO, id);
       return new ResponseEntity<>(customerService.updateCustomer(id, customerDTO), HttpStatus.OK);
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


}
