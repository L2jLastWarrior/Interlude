package com.l2j.util;

import java.io.File;
import java.io.FileFilter;

/**
 * @author Konstantinos
 */
public class SqlEngine implements FileFilter{
    
    @Override
    public boolean accept(File f){
        if((f==null) || !f.isFile()){
            return false;
        }
        return f.getName().toString().endsWith(".sql");
    }
}
