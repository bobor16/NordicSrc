/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Ilogic;

import Interfaces.All.ICase;
import Interfaces.All.IFileChooser;
import Interfaces.All.IUser;
import Interfaces.All.ISystemLog;
import Interfaces.All.iAuthenticate;
import Interfaces.Idata.Idata;
import LogicLayer.Case;
import LogicLayer.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mehgn
 */
public interface Ilogic extends iAuthenticate, ISystemLog, IFileChooser, ICase, IUser {

    public void injectData(Idata data);
    public Boolean passwordCheck(String password);
    public void addCaseToList(Case aCase);

}
