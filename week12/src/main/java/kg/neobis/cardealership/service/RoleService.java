package kg.neobis.cardealership.service;

import kg.neobis.cardealership.entity.Role;
import kg.neobis.cardealership.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public void addRole(Role role) {
        roleRepository.save(role);
    }
}
