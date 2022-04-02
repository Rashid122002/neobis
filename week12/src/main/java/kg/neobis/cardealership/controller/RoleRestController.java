package kg.neobis.cardealership.controller;

import kg.neobis.cardealership.entity.Role;
import kg.neobis.cardealership.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
public class RoleRestController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<?> addNewRole(@RequestBody Role newRole) {
        try {
            roleService.addRole(newRole);
            return ResponseEntity.ok("Role was added successfully");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
