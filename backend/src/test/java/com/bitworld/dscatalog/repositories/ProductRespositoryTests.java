package com.bitworld.dscatalog.repositories;

import com.bitworld.dscatalog.entities.Product;
import com.bitworld.dscatalog.tests.Factory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class ProductRespositoryTests {

    @Autowired
    private ProductRepository repository;

    private long exintingId;
    private long countTotalProducts;

    @BeforeEach
    void setUp() {
        exintingId = 1L;
        countTotalProducts = 25L;
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull(){

        Product product = Factory.createProduct();
        product.setId(null);

        product = repository.save(product);

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(countTotalProducts + 1, product.getId());

    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){

        repository.deleteById(exintingId);

        Optional<Product> result = repository.findById(1L);
        Assertions.assertFalse(result.isPresent());
    }

}
