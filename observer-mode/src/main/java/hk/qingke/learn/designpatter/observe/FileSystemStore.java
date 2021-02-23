package hk.qingke.learn.designpatter.observe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FileSystemStore implements ApplicationListener<StoreEvent> {

    private final static Logger LOGGER = LoggerFactory.getLogger(FileSystemStore.class);

    @Override
    public void onApplicationEvent(StoreEvent event) {
        LOGGER.info("this is in file system store: {}: {}",this.hashCode(), event.getContent());
    }
}
