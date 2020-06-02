package org.example.priceengine.controller;

import org.example.priceengine.dto.PriceDto;
import org.example.priceengine.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("calculateFirst50UnitsBy/{productId}")
    @CrossOrigin
    public ResponseEntity<List<PriceDto>> calculateFirst50Units(@PathVariable Integer productId) {

        List<PriceDto> response = priceService.calculateFirst50Units(productId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("calculateBy/{productId}/{units}")
    @CrossOrigin
    public ResponseEntity<PriceDto> calculatePriceByProduct(@PathVariable Integer productId, @PathVariable Integer units) {

        PriceDto response = priceService.calculatePriceByProduct(productId, units);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
