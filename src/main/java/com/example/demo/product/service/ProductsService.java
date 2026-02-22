package com.example.demo.product.service;

import com.example.demo.product.dto.CategoryRequest;
import com.example.demo.product.dto.ProductsRequest;
import com.example.demo.product.dto.SellProductsRequest;
import com.example.demo.product.entity.CategoriesEntity;
import com.example.demo.product.entity.ProductsEntity;
import com.example.demo.product.repository.CategoriesRepository;
import com.example.demo.product.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }


    public void saveProducts(ProductsRequest productsRequest){
        ProductsEntity productsEntity = new ProductsEntity();
        productsEntity.setCategory_id(productsRequest.getCategory_id());
        productsEntity.setName(productsRequest.getName());
        productsEntity.setDescription(productsRequest.getDescription());
        productsEntity.setPrice(productsRequest.getPrice());
        productsEntity.setStock(productsRequest.getStock());
        productsRepository.save(productsEntity);
    }

    public List<ProductsRequest> findall() {
        List<ProductsRequest> productsRequestList = new ArrayList<>();
        List<ProductsEntity> productsEntities = (List<ProductsEntity>) productsRepository.findAll();


        for (int i = 0; i < productsEntities.size(); i++){
            ProductsRequest productsRequest = new ProductsRequest();
            productsRequest.setId(productsEntities.get(i).getId());
            productsRequest.setCategory_id(productsEntities.get(i).getCategory_id());
            productsRequest.setName(productsEntities.get(i).getName());
            productsRequest.setDescription(productsEntities.get(i).getDescription());
            productsRequest.setPrice(productsEntities.get(i).getPrice());
            productsRequest.setStock(productsEntities.get(i).getStock());
            productsRequestList.add(productsRequest);

        }
        return productsRequestList;
    }

    public void save(SellProductsRequest sellProductsRequest) {

        if(sellProductsRequest.getAmount() > 0) {
           if (sellProductsRequest.getMoneyMyself().compareTo(BigDecimal.ZERO) > 0) {
               ProductsEntity productsEntity = productsRepository.findById(sellProductsRequest.getProductsID())
                       .orElseThrow(() -> new RuntimeException("ไม่พบสินค้า"));

               int buyAmount = sellProductsRequest.getAmount().intValue();
               if (productsEntity.getStock() >= buyAmount) {
                   BigDecimal totalPrice = productsEntity.getPrice().multiply(new BigDecimal(buyAmount));
                   if (sellProductsRequest.getMoneyMyself().compareTo(totalPrice) >= 0) {
                        int newstock = productsEntity.getStock() - buyAmount;
                        productsEntity.setStock(newstock);
                        productsRepository.save(productsEntity);
                   }else {
                       throw new RuntimeException("เงินไม่พอจ่าย! ราคารวมคือ: " + totalPrice);
                   }
               }else {
                   throw new RuntimeException("ของในสต็อกไม่พอขาย! มีเหลือแค่: " + productsEntity.getStock());
               }
           }
        }

    }

}
