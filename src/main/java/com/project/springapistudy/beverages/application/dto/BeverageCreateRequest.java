package com.project.springapistudy.beverages.application.dto;

import com.project.springapistudy.beverages.domain.Beverage;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class BeverageCreateRequest {

    private static final String MINIMUM_PRICE = "가격은 최소 1원 이상이 되야 합니다.";

    @NotBlank
    private String name;

    @Min(value = 1, message = MINIMUM_PRICE)
    private Long price;

    private BeverageCreateRequest() {
    }

    public static BeverageCreateRequest of(String name, Long price) {
        BeverageCreateRequest beverageCreateRequest = new BeverageCreateRequest();
        beverageCreateRequest.name = name;
        beverageCreateRequest.price = price;
        return beverageCreateRequest;
    }

    public Beverage to() {
        return new Beverage(this.name, this.price);
    }
}
