package com.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.business.entities.Orders;
import com.business.entities.User;
import com.business.repositories.OrderRepository;
@Component
public class OrderServices
{
	@Autowired
	private OrderRepository orderRepository;

	//get all orders
	public List<Orders> getOrders()
	{
		List<Orders> list=this.orderRepository.findAll();
		return list;
	}
	//save Order
	public void saveOrder(Orders order)
	{
		this.orderRepository.save(order);
	}
	
	//update order
	public void updateOrder(int id,Orders order)
	{
		order.setoId(id);
		this.orderRepository.save(order);
		 
	}
	
	//delete order
	public void deleteOrder(int id)
	{
		this.orderRepository.deleteById(id);
	}
	
	//get Order history of user
	public List<Orders> getOrdersForUser(User user)
	{
	 return  this.orderRepository.findOrdersByUser(user);
	}

    //process the Order
    public double processOrder(int id) {

        Orders order = this.orderRepository.getReferenceById(id);

        if (order.getoQuantity() <= 0) { // The mutation test failes -> 0 * bla = 0 -> test green
            System.out.println("Invalid quantity.");
            return 0;
        }

        if (order.getUser() != null && order.getoName() != null && !order.getoName().isEmpty()) {
            System.out.println("Processing order for user: " + order.getUser().getUname());
        } else {
            System.out.println("Order must have a user and product name.");
            return 0;
        }

        double discount = 0;
        if (order.getoQuantity() >= 10) {
            discount = 0.20;
        } else if (order.getoQuantity() >= 5) {
            discount = 0.10;
        }

        double subtotal = order.getoPrice() * order.getoQuantity();
        double discountAmount = subtotal * discount;
        double totalAmmout = subtotal - discountAmount;

        order.setTotalAmmout(totalAmmout);
        this.orderRepository.save(order);

        return totalAmmout;
    }
}
