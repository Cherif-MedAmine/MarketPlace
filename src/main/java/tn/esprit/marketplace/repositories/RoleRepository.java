package tn.esprit.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.marketplace.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {


    Role findByRoleName(String roleName);
}


