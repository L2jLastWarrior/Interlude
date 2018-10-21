package com.l2j.tools.dbinstaller.images;

import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class ImagesTable{
    public static final Map<String,ImageIcon> IMAGES = new HashMap<>();
    public static final String IMAGES_DIRECTORY = "../images";
    
    public static ImageIcon getImage(String name){
        if(!IMAGES.containsKey(name)){
            IMAGES.put(name,new ImageIcon(IMAGES_DIRECTORY + name));
        }
        return IMAGES.get(name);
    }
}
