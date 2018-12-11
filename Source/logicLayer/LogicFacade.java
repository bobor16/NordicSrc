/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;

/**
 *
 * @author mehgn
 */
import dataLayer.ClientController;
import dataLayer.Packet;
import interfaces.iLogic.Ilogic;
import interfaces.iData.Idata;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mehgn
 */
public class LogicFacade implements interfaces.iLogic.Ilogic {

    private static Idata data;
    private static Ilogic logic;

    private PasswordValidation passwordChecker = new PasswordValidation();

    @Override
    public void injectData(Idata data) {
        this.data = data;
    }

    public LogicFacade() {
    }

    public static Ilogic getInstance() {
        return logic;
    }

    public Boolean passwordCheck(String password) {
        return passwordChecker.checkPassword(password);
    }

    @Override
    public void addCaseToList(Case aCase) {
    }

    @Override
    public ArrayList<Case> getCaseList() {
        return data.getCaseList();
    }

    public static void main(String[] args) {
        LogicFacade s = new LogicFacade();
//        for (int i = 0; i < s.getCaseList().size(); i++) {
//            s.getCaseList().get(i).getCaseName();
//        }
        System.out.println(s.displayUsers());

    }

    //ER NULL!?!?!?!
    @Override
    public ArrayList<User> displayUsers() {
        return data.displayUsers();
    }

    @Override
    public void deleteUser(String email) {
        data.deleteUser(email);
    }
    
    
    
    
    
     
     
}

