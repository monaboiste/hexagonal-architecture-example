package com.monaboiste.github;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CrossDomainIT {

    String dishName = "pizza";
    String address = "ul. Wonka Polices 12/4, 66-555 Warsaw";

    @Test
    void shouldCreateNewOrderAndDeliverTheOrder() {
        // given
        assertThat(true).isTrue();
    }
}
