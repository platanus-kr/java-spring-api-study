package com.project.springapistudy.beverages.application.dto;

import com.project.springapistudy.beverages.domain.Beverage;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class BeverageUpdateRequest {

    private static final String MINIMUM_PRICE = "가격은 최소 1원 이상이 되야 합니다.";

    @NotBlank
    private String name;

    @Min(value = 1, message = MINIMUM_PRICE)
    private Long price;

    public Beverage to() {
        return new Beverage(this.name, this.price);
    }
}
