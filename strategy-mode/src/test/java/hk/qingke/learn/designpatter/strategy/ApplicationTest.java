package hk.qingke.learn.designpatter.strategy;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApplicationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationTest.class);

    @Autowired
    private Map<String, Strategy<?>> storeStrategies;

    @Autowired
    private StrategyDispatch<String> stringStrategyDispatch;

    @Test
    void should_get_all_strategy() {
        this.storeStrategies.keySet().forEach(LOGGER::info);
        assertEquals(2, this.storeStrategies.size());
    }

    @Test
    void should_use_new_strategy() {
        stringStrategyDispatch.doHandler("FILE: this is a file");
        stringStrategyDispatch.doHandler("FILE: this is a file");

        stringStrategyDispatch.doHandler("S3: this is a S3");
        stringStrategyDispatch.doHandler("S3: this is a S3");
    }
}