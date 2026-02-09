package com.bitworld.dscatalog.repositories;

import com.bitworld.dscatalog.entities.Product;
import com.bitworld.dscatalog.tests.Factory;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductRespositoryTests {

    @Autowired
    private ProductRepository repository;

    private long exintingId;
    private long countTotalProducts;
    private long idNotExisting;

    @BeforeEach
    void setUp() {
        exintingId = 1L;
        countTotalProducts = 25L;
        idNotExisting = 100L;
    }

    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull(){

        Product product = Factory.createProduct();
        product.setId(null);

        product = repository.save(product);

        assertNotNull(product.getId());
        assertEquals(countTotalProducts + 1, product.getId());

    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists(){

        repository.deleteById(exintingId);

        Optional<Product> result = repository.findById(1L);
        assertFalse(result.isPresent());
    }

    @Test
    public void findByIdShouldReturnProductWhenIdExists(){

        Optional<Product> result = repository.findById(exintingId);
        assertFalse(result.isEmpty());

    }

    @Test
    public void findByIdShouldReturnProductWhenIdNotExists(){

        Optional<Product> result = repository.findById(idNotExisting);
        assertEquals(Optional.empty(), result);

    }

}
