package kg.neobis.cardealership.Service;

import kg.neobis.cardealership.Exception.EntityNotFoundException;
import kg.neobis.cardealership.Model.Operation;
import kg.neobis.cardealership.Repository.OperationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class OperationService {
    private OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public List<Operation> all() {
        return operationRepository.findAll();
    }

    public Operation getOperationById(Long id) {
        return operationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find operation ", id));
    }

    public void addNewOperation(@RequestBody Operation newOperation) {
        operationRepository.save(newOperation);
    }

    public Operation replaceOperation(@RequestBody Operation newOperation, @PathVariable Long id) {
        return operationRepository.findById(id)
                .map(operation -> {
                    operation.setOperationDate(newOperation.getOperationDate());
                    operation.setCarId(newOperation.getCarId());
                    operation.setDeliveryOrderId(newOperation.getDeliveryOrderId());
                    operation.setOperationDescription(newOperation.getOperationDescription());
                    operation.setFactoryPrice(newOperation.getFactoryPrice());
                    operation.setCostUpTo(newOperation.getCostUpTo());
                    operation.setTotalAmount(newOperation.getTotalAmount());
                    return operationRepository.save(operation);
                })
                .orElseGet(() -> {
                    newOperation.setOperationId(id);
                    return operationRepository.save(newOperation);
                });
    }

    public void deleteOperation(@PathVariable Long id) {
        boolean exists = operationRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("Could not find operation ", id);
        }
        operationRepository.deleteById(id);
    }
}
