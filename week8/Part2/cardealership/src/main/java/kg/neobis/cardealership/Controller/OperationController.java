package kg.neobis.cardealership.Controller;

import kg.neobis.cardealership.Model.Operation;
import kg.neobis.cardealership.Service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/operations")
public class OperationController {
    private final OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public List<Operation> getOperations() {
        return operationService.all();
    }

    @GetMapping("/{id}")
    public Operation getOperationById(@PathVariable Long id) {
        return operationService.getOperationById(id);
    }

    @PostMapping
    public void registerNewOperation(@RequestBody Operation newOperation) {
        operationService.addNewOperation(newOperation);
    }

    @PutMapping("/{id}")
    public Operation replaceOperation(@RequestBody Operation newOperation, @PathVariable Long id) {
        return operationService.replaceOperation(newOperation, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOperation(@PathVariable Long id) {
        operationService.deleteOperation(id);
    }
}
