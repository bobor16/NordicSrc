/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Ipresentation;

import Interfaces.Ilogic.Ilogic;


/**
 *
 * @author mehgn
 */
public interface Ipresentation {

    void injectLogic(Ilogic logic);

    void startApplication(String[] args);
}
