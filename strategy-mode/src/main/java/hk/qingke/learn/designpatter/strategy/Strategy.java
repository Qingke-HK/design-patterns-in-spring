package hk.qingke.learn.designpatter.strategy;

public interface Strategy<T> {
    boolean isMatcher(T target);

    void doHandler(T target);
}
