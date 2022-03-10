package kg.neobis.cardealership.service;

import kg.neobis.cardealership.entity.Car;
import kg.neobis.cardealership.exception.EntityNotFoundException;
import kg.neobis.cardealership.entity.Staff;
import kg.neobis.cardealership.model.StaffModel;
import kg.neobis.cardealership.repository.StaffRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

import static kg.neobis.cardealership.model.StaffModel.staffToStaffModel;

@Service
public class StaffService implements DAO<Staff, StaffModel, Long>  {
    private StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public List<StaffModel> entityListToModelList(Iterable<Staff> staff) {
        List<StaffModel> staffModelList = new ArrayList<StaffModel>();
        for(Staff staff1 : staff) {
            staffModelList.add(staffToStaffModel(staff1));
        }
        return staffModelList;
    }

    @Override
    public List<StaffModel> getAll() {
        return entityListToModelList(staffRepository.findAll());
    }

    @Override
    public StaffModel getById(Long id) throws EntityNotFoundException {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found staff: ", id));
        return staffToStaffModel(staff);
    }

    @Override
    public void add(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public Staff update(StaffModel staffModel, Long id) throws EntityNotFoundException {
        Staff staff = staffRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not found staff: ", id));
        staff.setLastName(staffModel.getLastName());
        staff.setFirstName(staffModel.getFirstName());
        staff.setPosition(staffModel.getPosition());
        staff.setPhoneNumber(staffModel.getPhoneNumber());
        return staffRepository.save(staff);
    }

    @Override
    public Long delete(Long id) throws EntityNotFoundException {
        if(!staffRepository.existsById(id)) {
            throw new EntityNotFoundException("Could not found staff: ", id);
        }
        staffRepository.deleteById(id);
        return id;
    }
}
