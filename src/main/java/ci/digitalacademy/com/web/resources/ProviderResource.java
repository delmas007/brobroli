package ci.digitalacademy.com.web.resources;

import ci.digitalacademy.com.service.ProviderService;
import ci.digitalacademy.com.service.dto.ProviderDTO;
import ci.digitalacademy.com.service.mapper.ProviderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
@Slf4j
@RequiredArgsConstructor
public class ProviderResource {

    private final ProviderService providerService;
    private final ProviderMapper providerMapper;

    @PostMapping
    public ResponseEntity<ProviderDTO> save(@RequestBody ProviderDTO provider){
        log.debug("REST request to save: {}", provider);
        return new ResponseEntity<>(providerService.save(provider), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ProviderDTO update(@RequestBody ProviderDTO provider, @PathVariable Long id){
        log.debug("REST request to update: {}", provider);
        return providerService.update(provider, id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneById(@PathVariable Long id){
        log.debug("REST request to get one by id: {}", id);
        return new ResponseEntity<>(providerService.findOneById(id),HttpStatus.OK );
    }

    @GetMapping
    public List<ProviderDTO> findAll(){
        log.debug("REST request to find all");
        return providerService.findAll();

    }

}
