package kg.neobis.cardealership.Service;

import kg.neobis.cardealership.Exception.EntityNotFoundException;
import kg.neobis.cardealership.Model.Staff;
import kg.neobis.cardealership.Repository.StaffRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StaffService {
    private StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> all() {
        return staffRepository.findAll();
    }

    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find staff ", id));
    }

    public void addNewStaff(@RequestBody Staff newStaff) {
        staffRepository.save(newStaff);
    }

    public Staff replaceStaff(@RequestBody Staff newStaff, @PathVariable Long id) {
        return staffRepository.findById(id)
                .map(staff -> {
                    staff.setLastName(newStaff.getLastName());
                    staff.setFirstName(newStaff.getFirstName());
                    staff.setPosition(newStaff.getPosition());
                    staff.setPhoneNumber(newStaff.getPhoneNumber());
                    return staffRepository.save(staff);
                })
                .orElseGet(() -> {
                    newStaff.setStaffId(id);
                    return staffRepository.save(newStaff);
                });
    }

    public void deleteStaffById(@PathVariable Long id) {
        boolean exists = staffRepository.existsById(id);
        if(!exists){
            throw new EntityNotFoundException("Could not find staff ", id);
        }
        staffRepository.deleteById(id);
    }
}
