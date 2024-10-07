package ci.digitalacademy.com.web.resources;

import ci.digitalacademy.com.service.ProviderService;
import ci.digitalacademy.com.service.dto.ProviderDTO;
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



    @PostMapping
    public ResponseEntity<ProviderDTO> saveProvider(@RequestBody ProviderDTO provider){
        log.debug("REST request to save provider: {}", provider);
        return new ResponseEntity<>(providerService.saveProvider(provider), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ProviderDTO update(@RequestBody ProviderDTO provider, @PathVariable Long id){
        log.debug("REST request to update: {}", provider);
        return providerService.update(provider, id);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<?> getOneById(@PathVariable Long id){
        log.debug("REST request to get one by id: {}", id);
        return new ResponseEntity<>(providerService.findOneById(id),HttpStatus.OK );
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getOneBySlug(@PathVariable String slug){
        log.debug("REST request to get one by slug: {}", slug);
        return new ResponseEntity<>(providerService.findOneBySlug(slug),HttpStatus.OK );
    }

    @GetMapping
    public List<ProviderDTO> findAll(){
        log.debug("REST request to find all");
        return providerService.findAll();
    }

}
