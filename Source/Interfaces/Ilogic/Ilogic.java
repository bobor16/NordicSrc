/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Ilogic;

import Interfaces.All.IFileChooser;
import Interfaces.All.IUser;
import Interfaces.All.ISystemLog;
import Interfaces.All.iAuthenticate;
import Interfaces.Idata.Idata;

/**
 *
 * @author mehgn
 */
public interface Ilogic extends iAuthenticate, IUser, ISystemLog, IFileChooser {

    public void injectData(Idata data);
    public Boolean passwordCheck(String password);

}
