package com.eitheror.eitherorresource;

import com.eitheror.eitherorresource.domain.Option;
import com.eitheror.eitherorresource.repositories.OptionRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * User: Dave Harms
 * Date: 7/3/22
 * Time: 3:36 PM
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.eitheror.eitherorresource.bootstrap"})
public class JpaTestSlice {

    @Autowired
    OptionRepository optionRepository;

    @Commit
    @Order(1)
    @Test
    void testJpaTestSlice() {
        long countBefore = optionRepository.count();
        assertThat(countBefore).isEqualTo(2);

        optionRepository.save(new Option("test", "test"));

        long countAfter = optionRepository.count();

        assertThat(countAfter).isGreaterThan(countBefore);
    }

    @Order(2)
    @Test
    void testTransaction() {
        long countBefore = optionRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }
}
