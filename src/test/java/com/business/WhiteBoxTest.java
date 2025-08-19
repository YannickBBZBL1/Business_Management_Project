package com.business;


import com.business.entities.Orders;
import com.business.entities.User;
import com.business.repositories.OrderRepository;
import com.business.services.OrderServices;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WhiteBoxTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServices orderService;

    @Test
    void test_processOrder_QuantityIsZeroReturnsZero() {
        int id = 1;
        Orders mockOrder = new Orders("Name", id, 10, 0, new Date(), new User());
        mockOrder.setoId(id);

        // Mock repository behavior
        Mockito.when(orderRepository.getReferenceById(id)).thenReturn(mockOrder);
        Mockito.when(orderRepository.save(mockOrder)).thenReturn(mockOrder);

        // Call service
        double price = orderService.processOrder(id);

        // Verify interaction
        Mockito.verify(orderRepository).getReferenceById(id);
        assertEquals(0, price);
    }

    @Test
    void test_processOrder_QuantityIsNegativeReturnsZero() {
        int id = 1;
        Orders mockOrder = new Orders("Name", id, 10, -1, new Date(), new User());
        mockOrder.setoId(id);

        // Mock repository behavior
        Mockito.when(orderRepository.getReferenceById(id)).thenReturn(mockOrder);
        Mockito.when(orderRepository.save(mockOrder)).thenReturn(mockOrder);

        // Call service
        double price = orderService.processOrder(id);

        // Verify interaction
        Mockito.verify(orderRepository).getReferenceById(id);
        assertEquals(0, price);
    }

    @Test
    void test_processOrder_UserIsNullReturnsZero() {
        int id = 1;
        Orders mockOrder = new Orders("Name", id, 10, 2, new Date(), null);
        mockOrder.setoId(id);

        // Mock repository behavior
        Mockito.when(orderRepository.getReferenceById(id)).thenReturn(mockOrder);
        Mockito.when(orderRepository.save(mockOrder)).thenReturn(mockOrder);

        // Call service
        double price = orderService.processOrder(id);

        // Verify interaction
        Mockito.verify(orderRepository).getReferenceById(id);
        assertEquals(0, price);
    }

    @Test
    void test_processOrder_NameIsNullReturnsZero() {
        int id = 1;
        Orders mockOrder = new Orders(null, id, 10, 2, new Date(), null);
        mockOrder.setoId(id);

        // Mock repository behavior
        Mockito.when(orderRepository.getReferenceById(id)).thenReturn(mockOrder);
        Mockito.when(orderRepository.save(mockOrder)).thenReturn(mockOrder);

        // Call service
        double price = orderService.processOrder(id);

        // Verify interaction
        Mockito.verify(orderRepository).getReferenceById(id);
        assertEquals(0, price);
    }

    @Test
    void test_processOrder_NameIsEmptyReturnsZero() {
        int id = 1;
        Orders mockOrder = new Orders("", id, 10, 2, new Date(), null);
        mockOrder.setoId(id);

        // Mock repository behavior
        Mockito.when(orderRepository.getReferenceById(id)).thenReturn(mockOrder);
        Mockito.when(orderRepository.save(mockOrder)).thenReturn(mockOrder);

        // Call service
        double price = orderService.processOrder(id);

        // Verify interaction
        Mockito.verify(orderRepository).getReferenceById(id);
        assertEquals(0, price);
    }

    @Test
    void test_processOrder_QuantityIsUnderFiveNoDiscount() {
        int id = 1;
        Orders mockOrder = new Orders("Name", id, 10, 2, new Date(), new User());
        mockOrder.setoId(id);

        // Mock repository behavior
        Mockito.when(orderRepository.getReferenceById(id)).thenReturn(mockOrder);
        Mockito.when(orderRepository.save(mockOrder)).thenReturn(mockOrder);

        // Call service
        double price = orderService.processOrder(id);

        // Verify interaction
        Mockito.verify(orderRepository).getReferenceById(id);
        assertEquals(20, price);
    }

    @Test
    void test_processOrder_QuantityIsFive10Discount() {
        int id = 1;
        Orders mockOrder = new Orders("Name", id, 10, 5, new Date(), new User());
        mockOrder.setoId(id);

        // Mock repository behavior
        Mockito.when(orderRepository.getReferenceById(id)).thenReturn(mockOrder);
        Mockito.when(orderRepository.save(mockOrder)).thenReturn(mockOrder);

        // Call service
        double price = orderService.processOrder(id);

        // Verify interaction
        Mockito.verify(orderRepository).getReferenceById(id);
        assertEquals(45, price);
    }

    @Test
    void test_processOrder_QuantityIsOverFive10Discount() {
        int id = 1;
        Orders mockOrder = new Orders("Name", id, 10, 6, new Date(), new User());
        mockOrder.setoId(id);

        // Mock repository behavior
        Mockito.when(orderRepository.getReferenceById(id)).thenReturn(mockOrder);
        Mockito.when(orderRepository.save(mockOrder)).thenReturn(mockOrder);

        // Call service
        double price = orderService.processOrder(id);

        // Verify interaction
        Mockito.verify(orderRepository).getReferenceById(id);
        assertEquals(54, price);
    }

    @Test
    void test_processOrder_QuantityIsUnderTen10Discount() {
        int id = 1;
        Orders mockOrder = new Orders("Name", id, 10, 9, new Date(), new User());
        mockOrder.setoId(id);

        // Mock repository behavior
        Mockito.when(orderRepository.getReferenceById(id)).thenReturn(mockOrder);
        Mockito.when(orderRepository.save(mockOrder)).thenReturn(mockOrder);

        // Call service
        double price = orderService.processOrder(id);

        // Verify interaction
        Mockito.verify(orderRepository).getReferenceById(id);
        assertEquals(81, price);
    }

    @Test
    void test_processOrder_QuantityIsTen20Discount() {
        int id = 1;
        Orders mockOrder = new Orders("Name", id, 10, 10, new Date(), new User());
        mockOrder.setoId(id);

        // Mock repository behavior
        Mockito.when(orderRepository.getReferenceById(id)).thenReturn(mockOrder);
        Mockito.when(orderRepository.save(mockOrder)).thenReturn(mockOrder);

        // Call service
        double price = orderService.processOrder(id);

        // Verify interaction
        Mockito.verify(orderRepository).getReferenceById(id);
        assertEquals(80, price);
    }

    @Test
    void test_processOrder_QuantityIsOverTen20Discount() {
        int id = 1;
        Orders mockOrder = new Orders("Name", id, 10, 11, new Date(), new User());
        mockOrder.setoId(id);

        // Mock repository behavior
        Mockito.when(orderRepository.getReferenceById(id)).thenReturn(mockOrder);
        Mockito.when(orderRepository.save(mockOrder)).thenReturn(mockOrder);

        // Call service
        double price = orderService.processOrder(id);

        // Verify interaction
        Mockito.verify(orderRepository).getReferenceById(id);
        assertEquals(88, price);
    }

    @Test
    void test_processOrder_QuantityIsMidValue20Discount() {
        int id = 1;
        Orders mockOrder = new Orders("Name", id, 10, 50, new Date(), new User());
        mockOrder.setoId(id);

        // Mock repository behavior
        Mockito.when(orderRepository.getReferenceById(id)).thenReturn(mockOrder);
        Mockito.when(orderRepository.save(mockOrder)).thenReturn(mockOrder);

        // Call service
        double price = orderService.processOrder(id);

        // Verify interaction
        Mockito.verify(orderRepository).getReferenceById(id);
        assertEquals(400, price);
    }
}
