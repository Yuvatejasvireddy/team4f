package com.teju.team4.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teju.team4.model.Order;
import com.teju.team4.model.Staff;
import com.teju.team4.repository.OrderRepository;
import com.teju.team4.repository.StaffRepository;

@RestController
@RequestMapping("/deliveryagent")
public class Deliveryagentcontroller {
    
	

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private OrderRepository orderRepository;
	
  //get all orders
    @GetMapping("/{dId}/orders")
    public ResponseEntity<List<Order>> getOrdersByDeliveryAgent(@PathVariable Long dId) {
        List<Order> orders = orderRepository.findByStaff_StaffId(dId);
        return ResponseEntity.ok(orders);
    }
    
    //changeorderstatus
    @PatchMapping("/orders/{orderId}")
    public ResponseEntity<?> updateOrderStatus(@PathVariable Long orderId, @RequestParam String s) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order ==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        }
        // change date of order delivery date 
        if (s.equals("delivered")) {
      
          order.setDeliveryDate(LocalDate.now());
        }
        
        order.setStatus(s);
        orderRepository.save(order);

        return ResponseEntity.ok("Order status updated successfully");
    }
    
    //verify payment mode
    @GetMapping("/{oid}")
    public ResponseEntity<?> getPaymentMode(@PathVariable Long oid)
    {
    	Order order = orderRepository.findById(oid).orElse(null);
    	if (order ==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
        }
    	
    	return ResponseEntity.ok(order.getPayment_mode());
    	
    }
    
    
    

}
