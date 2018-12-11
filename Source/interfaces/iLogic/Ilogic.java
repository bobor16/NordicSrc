/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.iLogic;

import interfaces.all.ICase;
import interfaces.all.IFileChooser;
import interfaces.all.iAuthenticate;
import interfaces.iData.Idata;
import java.util.ArrayList;
import logicLayer.Case;
import logicLayer.User;

/**
 *
 * @author mehgn
 */
public interface Ilogic extends iAuthenticate, IFileChooser, ICase {

    public void injectData(Idata data);
    public Boolean passwordCheck(String password);
    public void addCaseToList(Case aCase);
    public void deleteUser(String email);
    public ArrayList<User> displayUsers();

}
