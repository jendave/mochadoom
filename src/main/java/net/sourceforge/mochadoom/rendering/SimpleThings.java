package net.sourceforge.mochadoom.rendering;

/**
 * A very "simple" things class which just does serial rendering and uses all
 * the base methods from AbstractThings.
 *
 * @param <T>
 * @param <V>
 * @author velktron
 */


public final class SimpleThings<T, V>
        extends AbstractThings<T, V> {

    public SimpleThings(Renderer<T, V> R) {
        super(R);
    }

    @Override
    public void completeColumn() {
        colfunc.invoke();
    }
}
