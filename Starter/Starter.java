package Starter;

import Server.Interfaces.Ilogic.Ilogic;
import Client.Interfaces.Ipresentation.Ipresentation;
import Server.LogicLayer.LogicFacade;
import Client.presentationLayer.presentationFacade;
import Server.Interfaces.Idata.Idata;
import Server.dataLayer.DataFacade;

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