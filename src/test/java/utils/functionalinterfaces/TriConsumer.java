package utils.functionalinterfaces;

@FunctionalInterface
public interface TriConsumer<T, U, S> {
    void accept(T var1, U var2, S var3);
}
