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
public class SystemLog {
    
    private String logText;
    
    public SystemLog(){
        
    }
    
    public String getSystemLog(){
        return logText;
    }
    
    public void setSystemLog(String logText){
        
    }
    
    public void clearSystemLog(){
        this.logText = "";
    }
}
