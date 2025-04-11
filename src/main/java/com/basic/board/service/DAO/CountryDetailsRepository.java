package com.basic.board.service.DAO;

import com.basic.board.model.Entity.CountryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryDetailsRepository extends JpaRepository<CountryDetails, Integer> {
    CountryDetails findByIsoAlpha2 (String isoAlpha2);
}
