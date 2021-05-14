package ru.neoflex.cinema.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.cinema.domain.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{
    Role findByName(String name);
}
