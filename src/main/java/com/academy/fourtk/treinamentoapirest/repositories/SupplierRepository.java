package com.academy.fourtk.treinamentoapirest.repositories;

import com.academy.fourtk.treinamentoapirest.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
