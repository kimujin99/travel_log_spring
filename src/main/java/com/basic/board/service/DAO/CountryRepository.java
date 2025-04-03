package com.basic.board.service.DAO;

import com.basic.board.model.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findByKoreanName (String koreanName);
    Country findByIsoAlpha2 (String isoAlpha2);
}
