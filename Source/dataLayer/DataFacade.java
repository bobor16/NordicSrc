/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLayer;

/**
 *
 * @author mehgn
 */
import interfaces.iLogic.Ilogic;
import interfaces.iData.Idata;
import logicLayer.Case;
import logicLayer.LogicFacade;
import logicLayer.SystemLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import logicLayer.User;

/**
 *
 * @author mehgn
 */
public class DataFacade implements Idata {

    private static Idata data;
    private static Ilogic logic;

    public DataFacade() {
    }

    public static Idata getInstance() {
        return data;
    }

    @Override
    public void injectLogic(Ilogic logic) {
        this.logic = logic;
    }

    @Override
    public ArrayList<Case> getCaseList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> displayUsers() {
        ClientController cc = new ClientController();
        ArrayList<User> userEmailList = new ArrayList<>();
        for(int i = 0; i < cc.displayUsers().size(); i++){
            userEmailList.add(new User(cc.displayUsers().get(i)));
        }
        return userEmailList;
    }
    

    @Override
    public void deleteUser(String email) {
        ClientController cc = new ClientController();
        cc.deleteUser(email);
    }
 
  

    

}
