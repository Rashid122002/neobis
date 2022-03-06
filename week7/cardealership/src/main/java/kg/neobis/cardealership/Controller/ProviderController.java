package kg.neobis.cardealership.Controller;

import kg.neobis.cardealership.Model.Provider;
import kg.neobis.cardealership.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/providers")
public class ProviderController {
    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping
    public List<Provider> getProviders() {
        return providerService.all();
    }

    @GetMapping("/{id}")
    public Provider getProviderById(@PathVariable Long id) {
        return providerService.getProviderById(id);
    }

    @PostMapping
    public void registerNewProvider(@RequestBody Provider newProvider) {
        providerService.addNewProvider(newProvider);
    }

    @PutMapping("/{id}")
    public Provider replaceProvider(@RequestBody Provider newProvider, @PathVariable Long id) {
        return providerService.replaceProvider(newProvider, id);
    }

    @DeleteMapping("/{id}")
    public void deleteSProvider(@PathVariable Long id) {
        providerService.deleteProviderById(id);
    }
}
