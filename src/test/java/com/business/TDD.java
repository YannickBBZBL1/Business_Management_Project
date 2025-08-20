package com.business;


import com.business.entities.Product;
import com.business.entities.User;
import com.business.repositories.ProductRepository;
import com.business.services.ProductServices;
import net.bytebuddy.dynamic.DynamicType;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TDD {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServices productServices;

    @Test
    void test_calculateFinalPrice_PriceUnderHundredLowMwst() {
        int id = 1;
        Product mockProduct = new Product(id, "product", "description", 4);

        // Mock repository behavior
        Optional<Product> optionalProduct = Optional.of(mockProduct);
        Mockito.when(productRepository.findById(id)).thenReturn(optionalProduct);
        Mockito.when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        // Call service
        double price = productServices.calculateFinalPrice(12, id);

        // Verify interaction
        Mockito.verify(productRepository).findById(id);
        assertEquals(16.84, price);
    }

    @Test
    void test_calculateFinalPrice_PriceHundredHighMwst() {
        int id = 1;
        Product mockProduct = new Product(id, "product", "description", 4);

        // Mock repository behavior
        Optional<Product> optionalProduct = Optional.of(mockProduct);
        Mockito.when(productRepository.findById(id)).thenReturn(optionalProduct);
        Mockito.when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        // Call service
        double price = productServices.calculateFinalPrice(100, id);

        // Verify interaction
        Mockito.verify(productRepository).findById(id);
        assertEquals(123.0, price);
    }

    @Test
    void test_calculateFinalPrice_PriceOverHundredHighMwst() {
        int id = 1;
        Product mockProduct = new Product(id, "product", "description", 5);

        // Mock repository behavior
        Optional<Product> optionalProduct = Optional.of(mockProduct);
        Mockito.when(productRepository.findById(id)).thenReturn(optionalProduct);
        Mockito.when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        // Call service
        double price = productServices.calculateFinalPrice(101, id);

        // Verify interaction
        Mockito.verify(productRepository).findById(id);
        assertEquals(125.19, price);
    }

    @Test
    void test_calculateFinalPrice_Weight11HeavyPrice() {
        int id = 1;
        Product mockProduct = new Product(id, "product", "description", 11);

        // Mock repository behavior
        Optional<Product> optionalProduct = Optional.of(mockProduct);
        Mockito.when(productRepository.findById(id)).thenReturn(optionalProduct);
        Mockito.when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        // Call service
        double price = productServices.calculateFinalPrice(10, id);

        // Verify interaction
        Mockito.verify(productRepository).findById(id);
        assertEquals(12.700000000000001, price);
    }

    @Test
    void test_calculateFinalPrice_Weight10MidPrice() {
        int id = 1;
        Product mockProduct = new Product(id, "product", "description", 10);

        // Mock repository behavior
        Optional<Product> optionalProduct = Optional.of(mockProduct);
        Mockito.when(productRepository.findById(id)).thenReturn(optionalProduct);
        Mockito.when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        // Call service
        double price = productServices.calculateFinalPrice(10, id);

        // Verify interaction
        Mockito.verify(productRepository).findById(id);
        assertEquals(18.200000000000003, price);
    }

    @Test
    void test_calculateFinalPrice_Weight9MidPrice() {
        int id = 1;
        Product mockProduct = new Product(id, "product", "description", 9);

        // Mock repository behavior
        Optional<Product> optionalProduct = Optional.of(mockProduct);
        Mockito.when(productRepository.findById(id)).thenReturn(optionalProduct);
        Mockito.when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        // Call service
        double price = productServices.calculateFinalPrice(10, id);

        // Verify interaction
        Mockito.verify(productRepository).findById(id);
        assertEquals(16.700000000000003, price);
    }

    @Test
    void test_calculateFinalPrice_Weight6MidPrice() {
        int id = 1;
        Product mockProduct = new Product(id, "product", "description", 6);

        // Mock repository behavior
        Optional<Product> optionalProduct = Optional.of(mockProduct);
        Mockito.when(productRepository.findById(id)).thenReturn(optionalProduct);
        Mockito.when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        // Call service
        double price = productServices.calculateFinalPrice(10, id);

        // Verify interaction
        Mockito.verify(productRepository).findById(id);
        assertEquals(12.200000000000001, price);
    }

    @Test
    void test_calculateFinalPrice_Weight5LowPrice() {
        int id = 1;
        Product mockProduct = new Product(id, "product", "description", 5);

        // Mock repository behavior
        Optional<Product> optionalProduct = Optional.of(mockProduct);
        Mockito.when(productRepository.findById(id)).thenReturn(optionalProduct);
        Mockito.when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        // Call service
        double price = productServices.calculateFinalPrice(10, id);

        // Verify interaction
        Mockito.verify(productRepository).findById(id);
        assertEquals(15.700000000000001, price);
    }

    @Test
    void test_calculateFinalPrice_Weight4LowPrice() {
        int id = 1;
        Product mockProduct = new Product(id, "product", "description", 4);

        // Mock repository behavior
        Optional<Product> optionalProduct = Optional.of(mockProduct);
        Mockito.when(productRepository.findById(id)).thenReturn(optionalProduct);
        Mockito.when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        // Call service
        double price = productServices.calculateFinalPrice(10, id);

        // Verify interaction
        Mockito.verify(productRepository).findById(id);
        assertEquals(14.700000000000001, price);
    }

    @Test
    void test_calculateFinalPrice_Weight1LowPrice() {
        int id = 1;
        Product mockProduct = new Product(id, "product", "description", 1);

        // Mock repository behavior
        Optional<Product> optionalProduct = Optional.of(mockProduct);
        Mockito.when(productRepository.findById(id)).thenReturn(optionalProduct);
        Mockito.when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        // Call service
        double price = productServices.calculateFinalPrice(10, id);

        // Verify interaction
        Mockito.verify(productRepository).findById(id);
        assertEquals(11.700000000000001, price);
    }

    @Test
    void test_calculateFinalPrice_Price501Surchage() {
        int id = 1;
        Product mockProduct = new Product(id, "product", "description", 4);

        // Mock repository behavior
        Optional<Product> optionalProduct = Optional.of(mockProduct);
        Mockito.when(productRepository.findById(id)).thenReturn(optionalProduct);
        Mockito.when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        // Call service
        double price = productServices.calculateFinalPrice(501, id);

        // Verify interaction
        Mockito.verify(productRepository).findById(id);
        assertEquals(650.1899999999999, price);
    }

    @Test
    void test_calculateFinalPrice_Price500NoSurchage() {
        int id = 1;
        Product mockProduct = new Product(id, "product", "description", 4);

        // Mock repository behavior
        Optional<Product> optionalProduct = Optional.of(mockProduct);
        Mockito.when(productRepository.findById(id)).thenReturn(optionalProduct);
        Mockito.when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        // Call service
        double price = productServices.calculateFinalPrice(500, id);

        // Verify interaction
        Mockito.verify(productRepository).findById(id);
        assertEquals(649.0, price);
    }

    @Test
    void test_calculateFinalPrice_Price499NoSurchage() {
        int id = 1;
        Product mockProduct = new Product(id, "product", "description", 4);

        // Mock repository behavior
        Optional<Product> optionalProduct = Optional.of(mockProduct);
        Mockito.when(productRepository.findById(id)).thenReturn(optionalProduct);
        Mockito.when(productRepository.save(mockProduct)).thenReturn(mockProduct);

        // Call service
        double price = productServices.calculateFinalPrice(499, id);

        // Verify interaction
        Mockito.verify(productRepository).findById(id);
        assertEquals(647.81, price);
    }
}
