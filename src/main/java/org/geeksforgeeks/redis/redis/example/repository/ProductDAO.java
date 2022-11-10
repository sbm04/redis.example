package org.geeksforgeeks.redis.redis.example.repository;

import java.util.List;

import org.geeksforgeeks.redis.redis.example.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {

    public static final String HASH_KEY = "Product";
    @Autowired
    private RedisTemplate template;

    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> getAll() {

        return template.opsForHash().values(HASH_KEY);
    }


}