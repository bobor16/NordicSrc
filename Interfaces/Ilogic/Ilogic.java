/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Ilogic;

import Interfaces.All.IUser;
import Interfaces.All.iAuthenticate;
import Interfaces.Idata.Idata;

/**
 *
 * @author mehgn
 */
public interface Ilogic extends iAuthenticate, IUser {

    public void injectData(Idata data);

}
