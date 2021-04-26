package ru.neoflex.cinema.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.cinema.domain.Actor;

public interface ActorRepo extends JpaRepository<Actor, Integer> {
}
