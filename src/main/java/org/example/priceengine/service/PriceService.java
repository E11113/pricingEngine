package org.example.priceengine.service;

import org.example.priceengine.dto.PriceDto;

import java.util.List;

public interface PriceService {

    List<PriceDto> calculateFirst50Units(Integer productId);
    PriceDto calculatePriceByProduct(Integer productId, Integer units);
}
