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
public class TreeNode {
    Attribute attribute;
    DataSet dataSet;
    LinkedList<TreeNode> children=new LinkedList<>();
    boolean isPure, leaf;
    String value;
    int level, ch;

    public TreeNode(int l, DataSet subSet, String val){
        level=l;
        dataSet=subSet;
        isPure=dataSet.isPure();
        ch=0;
        value=val;
    }
    
    public String getValue(){
        return value;
    }
    
    public void print(){

//        System.out.print(attribute.getName());
//        dataSet.debugPrint();
        if(children.isEmpty()){
//            System.out.println("");
            for(int j=0; j<level; j++){
                System.out.print("\t");
            }
            System.out.println("ANSWER: "+dataSet.get(0).getGoal().getValue()+"\n");
        }
        else{
            for(int i=0; i<children.size(); i++){
//                System.out.println("");
                for(int j=0; j<level; j++){
                    System.out.print("\t");
                }
                System.out.print(attribute.getName()+": "+children.get(i).getValue()+"\n");
                children.get(i).print();
            }
        }
    }
    
    public boolean isLeaf(){
        return leaf;
    }
    
    public TreeNode getChild(int i){
        return children.get(i);
    }
    
    public void split(){
        if(!isPure){
            Attribute attr=dataSet.bestSplit();//get Attribute with the biggest gained value
            attribute=attr; //assign attribute to tree node
            DataSet subset;
            if(attr!=null){
                int n=attr.getN();
                for(int i=0; i<n; i++){
                    subset=new DataSet();
                    for(int j=0; j<dataSet.size(); j++){
                        if(dataSet.get(j).getValueForAttribute(attr).equals(attr.getValue(i))){
                            subset.add(dataSet.get(j));
                            dataSet.delete(j);//remove data ebtry from current node's subset 
                            j--;
                        }
                    }
                    
                    if(!subset.isEmpty()){
                        subset.deleteAttribute(attr);
                        children.add(new TreeNode(level+1, subset, attribute.getValue(i)));
                        children.get(i).split();
                    }
                }
            }
        }
    }
}
