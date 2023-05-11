package com.kbstar.cart;

import com.kbstar.dto.Cart;
import com.kbstar.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class SelectIDTest {

    @Autowired
    CartService service;

    @Test
    void contextLoads()  {
       List<Cart> list = null;
        try {
            list = service.getMyCart("id01");
        } catch (Exception e) {
            log.info("에러..");
            e.printStackTrace();
        }
    }
}
