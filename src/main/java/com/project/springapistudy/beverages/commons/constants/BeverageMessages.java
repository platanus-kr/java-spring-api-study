package com.project.springapistudy.beverages.commons.constants;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum BeverageMessages {
    BEVERAGE_NOT_FOUND(1000L, "음료를 찾을 수 없습니다");

    private final long key;
    private final String name;

    public long getKey() {
        return key;
    }

    public String getName() {
        return name;
    }
}
