package hk.qingke.learn.designpatter.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class StrategyDispatch<T> implements ApplicationContextAware {
    private final static Logger LOGGER = LoggerFactory.getLogger(StrategyDispatch.class);

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void doHandler(T target) {
        Map<String, Strategy> storeStrategies = this.applicationContext.getBeansOfType(Strategy.class);

        for (Map.Entry<String, Strategy> entry : storeStrategies.entrySet()) {
            String name = entry.getKey();
            Strategy strategy = entry.getValue();

            if (strategy.isMatcher(target)) {
                LOGGER.info("{}:{} strategy will handler target object", name, strategy.hashCode());
                strategy.doHandler(target);
                return;
            }
        }
    }
}
