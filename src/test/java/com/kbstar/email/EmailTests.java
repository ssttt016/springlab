package com.kbstar.email;

import com.kbstar.util.SendMailUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@Slf4j
@SpringBootTest
class EmailTests {

    @Autowired
    SendMailUtil sendMailUtil;

    @Test
    void contextLoads() throws Exception {
        log.info("start email test -------------");
//        sendMailUtil.sendSimpleMessage("ssttt016@gmail.com","회원가입을 축하드립니다.");
        sendMailUtil.sendAuthMessage("ssttt016@gmail.com","코드 입력.");
    }

}
