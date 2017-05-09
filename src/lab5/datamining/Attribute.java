/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.datamining;

import java.util.LinkedList;

/**
 *
 * @author juanp
 */
public class Attribute {
    
    int n;
    String name;
    String[] value=new String[10];
    
    public Attribute(String name, String[] vals){
        this.name=name.replaceAll("\\s+","");
        n=vals.length;
        for(int i=0; i<vals.length; i++){
            value[i]=vals[i];
        }
    }
    
    public int getIndexForValue(String val){
        for(int i=0; i<n; i++){
            if(value[i]==val)return i;
        }
        return -1;
    }
    
    public int getN(){
        return n;
    }
    
    public String getValue(int i){
        return value[i];
    }
    
    public String getName(){
        return name;
    }
    
    public LinkedList<String> getValues(){
        LinkedList<String> listValues=new LinkedList();
        for(int i=0; i<n; i++){
            listValues.add(value[i]);
        }
        return listValues;
    }
    
    
}
