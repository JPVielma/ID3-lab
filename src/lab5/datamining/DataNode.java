/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.datamining;

/**
 *
 * @author juanp
 */
public class DataNode {
    Attribute attribute;
    String value;
    
    public DataNode(Attribute a, String v){
        attribute=a;
        value=v;
    }
    
    public Attribute getAttribute(){
        return attribute;
    }
    
    public String getValue(){
        return value;
    }
    
}
