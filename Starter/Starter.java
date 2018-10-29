package Starter;

import Interfaces.Idata.Idata;
import Interfaces.Ilogic.Ilogic;
import Interfaces.Ipresentation.Ipresentation;
import dataLayer.DataFacade;
import logicLayer.LogicFacade;
import presentationLayer.presentationFacade;

public class Starter {

    /*
    Injects ILogic object with IData object data
    Injects IGUI object with ILogic objects data
    Calls startApplication() method in presentationFacade
    */
    public static void main(String[] args) {
        Ilogic logic = new LogicFacade();
        Ipresentation ui = new presentationFacade();
        Idata data = new DataFacade();
        logic.injectData(data);
        ui.injectLogic(logic);
        ui.startApplication(args);
    }

}