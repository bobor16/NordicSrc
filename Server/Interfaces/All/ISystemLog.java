/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.All;

import logicLayer.SystemLog;

import java.util.List;

/**
 *
 * @author mehgn
 */
public interface ISystemLog {
    public List<SystemLog> getSystemLog();
    public void setSystemLog(String systemLogText);
    public void clearSystemLog();
}
