package ru.neoflex.cinema.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.cinema.domain.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByNickname(String name);
    User findByEmail(String email);
}
