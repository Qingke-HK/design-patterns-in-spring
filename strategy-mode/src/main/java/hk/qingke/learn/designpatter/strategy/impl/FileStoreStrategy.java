package hk.qingke.learn.designpatter.strategy.impl;

import hk.qingke.learn.designpatter.strategy.Strategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FileStoreStrategy implements Strategy<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileStoreStrategy.class);

    @Override
    public boolean isMatcher(String target) {
        return target.startsWith("FILE:");
    }

    @Override
    public void doHandler(String target) {
        LOGGER.info("this is in file store strategy");
    }
}
