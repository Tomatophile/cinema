package ru.neoflex.cinema.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.cinema.domain.Voucher;

public interface VoucherRepo extends JpaRepository<Voucher, Integer> {
}
