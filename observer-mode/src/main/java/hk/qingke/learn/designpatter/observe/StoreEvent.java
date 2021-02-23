package hk.qingke.learn.designpatter.observe;

import org.springframework.context.ApplicationEvent;

public class StoreEvent extends ApplicationEvent {

    private final String content;

    public StoreEvent(Object source, String content) {
        super(source);
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
