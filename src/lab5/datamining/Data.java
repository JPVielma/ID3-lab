/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.datamining;

import java.util.LinkedList;
import static lab5.datamining.Lab5DataMining.attributeList;

/**
 *
 * @author juanp
 */
public class Data {

    LinkedList<DataNode> attributes=new LinkedList();
    DataNode goal;
    
    public Data(String[] attr){
        int size=attributeList.size()-1;
        for(int i=0; i<size; i++){
            attributes.add(new DataNode(attributeList.get(i), attr[i]));
        }
        goal=new DataNode(attributeList.get(size), attr[size]);
    }
    public void deleteAttribute(Attribute attr){
        for(int i=0; i<attributes.size(); i++){
            if(attributes.get(i).getAttribute().equals(attr)){
                attributes.remove(i);
            }
//            else System.out.println("Attributes: "+attributes.get(i).getAttribute().getName());
        }
    }
    
    public String getValueForAttribute(Attribute attr){
        
        if(attr.equals(goal.getAttribute())){
            return goal.getValue();
        }
        
        for(int i=0; i<attributes.size(); i++){
//            System.out.println(attributeList.get(i).getName());
//            System.out.println(attributes.get(i).getAttribute().getName());
            if(attributes.get(i).getAttribute().equals(attr)){
                return attributes.get(i).getValue();
            }
        }
        return null;
    }
    
    public DataNode getGoal(){
        return goal;
    }
    
}
