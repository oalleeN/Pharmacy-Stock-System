package com.pharmacy.stock.repository;

import com.pharmacy.stock.model.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {

    Medicament findByCode(String code);
}
