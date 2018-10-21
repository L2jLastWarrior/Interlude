/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.l2j.tools.dbinstaller;

/**
 *
 * @author Konstantinos
 */
public abstract class AbstractDBLauncher {
    
    protected static String getArg(String arg,String[] args){
        try{
            int i = 0;
            do{
                
            }
            while(!arg.equalsIgnoreCase(args[i++]));
            return args[i];
        }
        catch(Exception ex){
            return null;
        }
    }
}
