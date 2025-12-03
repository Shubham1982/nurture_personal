package com.nurturepersonal.nurturepersonal.implementation;

import com.nurturepersonal.nurturepersonal.entity.Retailer;
import com.nurturepersonal.nurturepersonal.repo.RetailerRepository;
import com.nurturepersonal.nurturepersonal.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RetailerServiceImpl implements RetailerService {

    @Autowired
    private RetailerRepository retailerRepository;

    @Override
    public Retailer getRetailer(Long id) {
        Optional<Retailer> retailer = retailerRepository.findById(id);
        return retailer.orElse(null);
    }
}
