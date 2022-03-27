package kg.neobis.cardealership.model;

import kg.neobis.cardealership.entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffModel {
    private Long staffId;
    private String lastName;
    private String firstName;
    private String position;
    private String phoneNumber;

    public static StaffModel staffToStaffModel(Staff staff) {
        StaffModel staffModel = new StaffModel();
        staffModel.setStaffId(staff.getStaffId());
        staffModel.setLastName(staff.getLastName());
        staffModel.setFirstName(staff.getFirstName());
        staffModel.setPosition(staff.getPosition());
        staffModel.setPhoneNumber(staff.getPhoneNumber());
        return staffModel;
    }
}
