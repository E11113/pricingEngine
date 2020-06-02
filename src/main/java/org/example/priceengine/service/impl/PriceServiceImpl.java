package org.example.priceengine.service.impl;

import org.example.priceengine.dto.PriceDto;
import org.example.priceengine.entity.Product;
import org.example.priceengine.repository.ProductRepository;
import org.example.priceengine.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<PriceDto> calculateFirst50Units(Integer productId) {

        Product product = productRepository.findById(productId).get();
        List<PriceDto> priceDtos= new ArrayList<>();
        for(int i = 1; i <= 50; i++) {
            priceDtos.add(calculatePrice(product, i));
        }
        return priceDtos;
    }

    @Override
    public PriceDto calculatePriceByProduct(Integer productId, Integer units) {
        Product product = productRepository.findById(productId).get();
        return calculatePrice(product, units);
    }

    public PriceDto calculatePrice(Product product, Integer totalUnits){

        PriceDto priceDto = new PriceDto();
        Integer cartonCount = (int) Math.floor(totalUnits / product.getUnitsPerCarton());
        Integer units = totalUnits % product.getUnitsPerCarton();
        Double unitPrice = product.getCartonPrice() / product.getUnitsPerCarton();
        priceDto.setCartons(cartonCount);
        priceDto.setUnits(units);
        priceDto.setId(product.getId());

        if(cartonCount >= 3 ){
            priceDto.setPrice((cartonCount * product.getCartonPrice() * 0.9) + (units * unitPrice * 1.3));
        }
        else{
            priceDto.setPrice(totalUnits * unitPrice * 1.3);
        }

        return priceDto;
    }
}
