/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicLayer;

import Interfaces.Idata.Idata;
import Interfaces.Ilogic.Ilogic;

/**
 *
 * @author mehgn
 */
public class LogicFacade implements Interfaces.Ilogic.Ilogic  {

    private static Idata data;
    private static Ilogic logic;

    @Override
    public void injectData(Idata data) {
        this.data = data;
    }
    
    public LogicFacade() {
    }

    public static Ilogic getInstance() {
        return logic;
    }
    
    public void print(){
        System.out.println("Hello World");
    }
    

}
