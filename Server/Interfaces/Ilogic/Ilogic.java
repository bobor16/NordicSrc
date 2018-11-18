/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Interfaces.Ilogic;

import Server.Interfaces.All.IFileChooser;
import Server.Interfaces.All.IUser;
import Server.Interfaces.All.ISystemLog;
import Server.Interfaces.All.iAuthenticate;
import Server.Interfaces.Idata.Idata;

/**
 *
 * @author mehgn
 */
public interface Ilogic extends iAuthenticate, IUser, ISystemLog, IFileChooser {

    public void injectData(Idata data);
    public Boolean passwordCheck(String password);

}
