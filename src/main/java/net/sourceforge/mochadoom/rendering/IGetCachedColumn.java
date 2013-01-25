package net.sourceforge.mochadoom.rendering;

/**
 * An interface used to ease the use of the GetCachedColumn by part
 * of parallelized renderers.
 *
 * @author Maes
 */

public interface IGetCachedColumn<T> {

    T GetCachedColumn(int tex, int col);

}
