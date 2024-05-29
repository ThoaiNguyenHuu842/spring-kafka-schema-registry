package com.thoainguyen.consumer;

import com.lda.test.kafka.schema.Order;
import com.lda.test.kafka.schema.SMessage;
import java.util.function.Consumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

  @Configuration
  public class FulfillmentServiceConsumer {

    @Bean
    public Consumer<Order> consumeOrderProcessed() {
      return order -> {
        SMessage a;
        System.out.println("Processing shipment for order: " + order);
      };
    }

  }
