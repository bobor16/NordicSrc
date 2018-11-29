package Interfaces.Idata;

import Interfaces.All.ICase;
import Interfaces.Ilogic.Ilogic;
import Interfaces.All.IUser;
import Interfaces.All.ISystemLog;
import Interfaces.All.iAuthenticate;
import LogicLayer.Case;
import java.util.List;

/**
 *
 * @author mehgn
 */
public interface Idata extends ISystemLog, iAuthenticate, ICase, IUser{
    public void injectLogic(Ilogic logic);
}
