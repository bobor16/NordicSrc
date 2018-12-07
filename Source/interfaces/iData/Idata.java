package interfaces.iData;

import interfaces.all.ICase;
import interfaces.iLogic.Ilogic;
import interfaces.all.iAuthenticate;

/**
 *
 * @author mehgn
 */
public interface Idata extends iAuthenticate, ICase{
    public void injectLogic(Ilogic logic);
}
