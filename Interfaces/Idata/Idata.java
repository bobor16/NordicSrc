package Interfaces.Idata;

import Interfaces.Ilogic.Ilogic;
import Interfaces.All.IUser;
import Interfaces.All.ISystemLog;
import Interfaces.All.iAuthenticate;

/**
 *
 * @author mehgn
 */
public interface Idata extends IUser, ISystemLog, iAuthenticate{
    public void injectLogic(Ilogic logic);

}
