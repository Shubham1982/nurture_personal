package com.nurturepersonal.nurturepersonal.repo;

import com.nurturepersonal.nurturepersonal.entity.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailerRepository extends JpaRepository<Retailer, Long>, JpaSpecificationExecutor<Retailer> {
}
