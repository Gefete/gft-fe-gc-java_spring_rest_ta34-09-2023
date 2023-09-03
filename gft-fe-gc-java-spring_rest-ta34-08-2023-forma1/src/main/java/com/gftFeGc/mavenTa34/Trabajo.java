package com.gftFeGc.mavenTa34;

import java.util.HashMap;
import java.util.Map;

public enum Trabajo {
	INFORMATICA(0), PROGRAMAR(1), INFERMERIA(2), GESTORDATOS(3);
	
	private int id;
	//Utiliza un hashmap para a partir de numeros coger trabajo
    private static final Map<Integer, Trabajo> MAP = new HashMap<>();
    
    //Construtoc
    private Trabajo(int id) { 
    	this.id = id; 
    }
    
    public int getId() { 
    	return id; 
    }
    
    public static Trabajo fromId(int id){
        return MAP.get(id);
    }
    
    static{
        for(Trabajo n : values()){
            MAP.put(n.getId(), n);
        }
    }
}