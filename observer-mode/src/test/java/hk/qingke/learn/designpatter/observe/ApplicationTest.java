package hk.qingke.learn.designpatter.observe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTest {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Test
    void should_store() {
        publisher.publishEvent(new StoreEvent(this, "CONTENT"));
        publisher.publishEvent(new StoreEvent(this, "CONTENT"));
    }
}