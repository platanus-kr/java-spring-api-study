package com.project.springapistudy.beverage.unit;

import com.project.springapistudy.beverages.application.BeverageService;
import com.project.springapistudy.beverages.application.dto.BeverageCreateRequest;
import com.project.springapistudy.beverages.application.dto.BeverageRetrieveResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class BeverageServiceTest {

    @Autowired
    private BeverageService beverageService;

    @Test
    void test() {
        for (long i = 1; i < 100; i++) {
            BeverageCreateRequest beverage = BeverageCreateRequest.of("메뉴 " + i, i * 1000);
            beverageService.create(beverage);
        }

        for (long i= 80; i < 90; i ++){
        }

        List<BeverageRetrieveResponse> beverageRetrieveRespons = beverageService.retrieveAll();
        for (BeverageRetrieveResponse b : beverageRetrieveRespons) {
//            System.out.println(b.getName() + " " + b.getCreated());
        }
    }



}
