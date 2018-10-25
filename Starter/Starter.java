
package Starter;
import presentationLayer.GUI;
import presentationLayer.LogInScreenController;

public class Starter {
    public static void main(String[] args) {
      //  LogInScreenController LSC = new LogInScreenController();
        GUI gui = new GUI();
        gui.guiStart(args); 
    }
}
