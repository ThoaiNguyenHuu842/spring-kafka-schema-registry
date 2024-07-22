package com.thoainguyen.rest;

import com.thoainguyen.kafka.schema.Order;
import com.thoainguyen.producer.Producer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class CheckoutEndpoint {

  private final Producer producer;

  @PostMapping("/app/order/{id}")
  public ResponseEntity<String> checkout(@PathVariable Integer id, @RequestParam Integer customerId) {
    System.out.println("Creating order with order id " + id + ", customer id " + customerId);
    Order order = new Order();
    order.setId(id);
    order.setCustomerId(customerId);
    producer.produceOrderCreated(order);
    return ResponseEntity.ok("OK");
  }
}
