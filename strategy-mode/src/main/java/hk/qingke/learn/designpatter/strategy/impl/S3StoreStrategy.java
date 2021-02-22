package hk.qingke.learn.designpatter.strategy.impl;

import hk.qingke.learn.designpatter.strategy.Strategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class S3StoreStrategy implements Strategy<String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(S3StoreStrategy.class);

    @Override
    public boolean isMatcher(String target) {
        return target.startsWith("S3");
    }

    @Override
    public void doHandler(String target) {
        LOGGER.info("this is in s3 store strategy");
    }
}
