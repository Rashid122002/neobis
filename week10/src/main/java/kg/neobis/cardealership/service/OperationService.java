package kg.neobis.cardealership.service;

import kg.neobis.cardealership.exception.EntityNotFoundException;
import kg.neobis.cardealership.entity.Operation;
import kg.neobis.cardealership.model.OperationModel;
import kg.neobis.cardealership.repository.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static kg.neobis.cardealership.model.OperationModel.operationToOperationModel;

@Service
public class OperationService implements DAO<Operation, OperationModel, Long> {
    private OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public List<OperationModel> entityListToModelList(Iterable<Operation> operations) {
        List<OperationModel> operationModelList = new ArrayList<OperationModel>();
        for (Operation operation : operations)
        {
            operationModelList.add(operationToOperationModel(operation));
        }
        return operationModelList;
    }

    @Override
    public List<OperationModel> getAll() {
        return entityListToModelList(operationRepository.findAll());
    }

    @Override
    public OperationModel getById(Long id) throws EntityNotFoundException {
        Operation operation = operationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found operation: ", id));
        return operationToOperationModel(operation);
    }

    @Override
    public void add(Operation operation) {
        operationRepository.save(operation);
    }

    @Override
    public Operation update(OperationModel operationModel, Long id) throws EntityNotFoundException {
        Operation operation = operationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found operation: ", id));
        operation.setOperationDate(operation.getOperationDate());
        operation.setCarId(operationModel.getCarId());
        operation.setDeliveryOrderId(operationModel.getDeliveryOrderId());
        operation.setOperationDescription(operationModel.getOperationDescription());
        operation.setFactoryPrice(operationModel.getFactoryPrice());
        operation.setCostUpTo(operationModel.getCostUpTo());
        operation.setTotalAmount(operationModel.getTotalAmount());
        return operationRepository.save(operation);
    }

    @Override
    public Long delete(Long id) throws EntityNotFoundException {
        if(!operationRepository.existsById(id)) {
            throw new EntityNotFoundException("Could not found operation: ", id);
        }
        operationRepository.deleteById(id);
        return id;
    }
}
