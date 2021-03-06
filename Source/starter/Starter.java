package starter;

import interfaces.iData.Idata;
import interfaces.iPresentation.Ipresentation;
import dataLayer.ClientController;
import presentationLayer.presentationFacade;
import interfaces.iLogic.Ilogic;
import logicLayer.LogicFacade;
import dataLayer.DataFacade;

public class Starter {

    /*
    Injects ILogic object with IData object data
    Injects IGUI object with ILogic objects data
    Calls startApplication() method in presentationFacade
     */
    public static void main(String[] args) {
        ClientController cc = new ClientController();
        Ilogic logic = new LogicFacade();
        Ipresentation ui = new presentationFacade();
        Idata data = new DataFacade();
        logic.injectData(data);
        ui.injectLogic(logic);
        ui.startApplication(args);
    }
    
    

}
