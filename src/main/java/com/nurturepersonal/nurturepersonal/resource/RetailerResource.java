package com.nurturepersonal.nurturepersonal.resource;

import com.nurturepersonal.nurturepersonal.entity.Retailer;
import com.nurturepersonal.nurturepersonal.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class RetailerResource {

    @Autowired
    private RetailerService retailerService;

    @GetMapping("/retailers")
    public ResponseEntity<Retailer> createRetailer(@RequestParam("id") Long id) throws URISyntaxException {
        Retailer retailer = retailerService.getRetailer(id);
        return new ResponseEntity<>(retailer, HttpStatus.OK);
    }
}