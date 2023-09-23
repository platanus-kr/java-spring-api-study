package com.project.springapistudy.beverage.unit;

import com.project.springapistudy.beverages.domain.Beverage;
import com.project.springapistudy.utils.SirenOrderApplicationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
@DisplayName("제조음료 단위 테스트")
public class BeverageTest extends SirenOrderApplicationTest {

    @DisplayName("제조음료 생성")
    @Test
    void 제조음료_생성() {
        final String 오늘의_커피 = "오늘의 커피";
        final long 가격 = 4500L;

        Beverage 제조음료 = new Beverage(오늘의_커피, 가격);

        assertThat(제조음료.getName()).isEqualTo(오늘의_커피);
        assertThat(제조음료.getPrice()).isEqualTo(가격);

    }

    @DisplayName("제조음료 수정")
    @Test
    void 제조음료_수정() {

        final String 아이스_아메리카노 = "아이스 아메리카노";
        final long 가격 = 5000L;

        Beverage 제조음료 = new Beverage("오늘의 커피", 4500L);

        Beverage 변경된_음료 = new Beverage(아이스_아메리카노, 가격);
        제조음료.update(변경된_음료);

        assertThat(제조음료.getName()).isEqualTo(아이스_아메리카노);
        assertThat(제조음료.getPrice()).isEqualTo(가격);
    }
}
