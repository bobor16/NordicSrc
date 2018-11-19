package Starter;

import Interfaces.Idata.Idata;
import Interfaces.Ipresentation.Ipresentation;
import presentationLayer.presentationFacade;
import Interfaces.Ilogic.Ilogic;
import LogicLayer.LogicFacade;
import dataLayer.DataFacade;

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
