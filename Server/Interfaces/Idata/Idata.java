/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Idata;

import Interfaces.All.ISystemLog;
import Interfaces.All.IUser;
import Interfaces.All.iAuthenticate;
import Interfaces.Ilogic.Ilogic;

/**
 *
 * @author mehgn
 */
public interface Idata extends IUser, ISystemLog, iAuthenticate{
    public void injectLogic(Ilogic logic);

}
