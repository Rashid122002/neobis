package kg.neobis.cardealership.Controller;

import kg.neobis.cardealership.Model.Car;
import kg.neobis.cardealership.Model.Staff;
import kg.neobis.cardealership.Service.CarService;
import kg.neobis.cardealership.Service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/staff")
public class StaffController {
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getStaff() {
        return staffService.all();
    }

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable Long id) {
        return staffService.getStaffById(id);
    }

    @PostMapping
    public void registerNewStaff(@RequestBody Staff newStaff) {
        staffService.addNewStaff(newStaff);
    }

    @PutMapping("/{id}")
    public Staff replaceStaff(@RequestBody Staff newStaff, @PathVariable Long id) {
        return staffService.replaceStaff(newStaff, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id) {
        staffService.deleteStaffById(id);
    }
}
