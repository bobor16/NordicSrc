package Server.Interfaces.Idata;

import Server.Interfaces.Ilogic.Ilogic;
import Server.Interfaces.All.IUser;
import Server.Interfaces.All.ISystemLog;
import Server.Interfaces.All.iAuthenticate;

/**
 *
 * @author mehgn
 */
public interface Idata extends IUser, ISystemLog, iAuthenticate{
    public void injectLogic(Ilogic logic);

}
