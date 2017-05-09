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
public class DataSet {
    LinkedList<Data> data=new LinkedList();
    Attribute goal;

    public DataSet(){
        
    }
    
    public boolean isEmpty(){
        return data.isEmpty();
    }
    
    public double getEntropy(Attribute attr, String value){
        
        double entropy=0;
        int count=0;
        int size=count(attr, value);
        for(int i=0; i<goal.getN(); i++){
            for(int j=0; j<data.size(); j++){
                if(data.get(j).getValueForAttribute(attr).equals(value))
                    if(goal.getValue(i).equals(data.get(j).getValueForAttribute(goal)))count++;
            }
            if(size!=0)entropy=entropy-(((double)count/size)*log2(((double)count/size)));
            count=0;
        }
        return entropy;
    }
    
    public double getEntropyOfSet(){
        
        double entropy=0;
        int count=0;
        int size=data.size();
        for(int i=0; i<goal.getN(); i++){
            for(int j=0; j<data.size(); j++){
                    if(goal.getValue(i).equals(data.get(j).getValueForAttribute(goal)))count++;
            }
            if(size!=0)entropy=entropy-(((double)count/size)*log2(((double)count/size)));
            count=0;
        }
        return entropy;
    }
    
    private int count(Attribute attr, String value){
        int count=0;
        for(int j=0; j<data.size(); j++){
            String aux=data.get(j).getValueForAttribute(attr);
            if(value.equals(aux))count++;
        }  
        return count;
    }
    
    private double log2(double f){
        if(f==0) return 0;
        return Math.log(f)/Math.log(2);
    }
    
    public double gainedValue(Attribute attr){
//        DataSet[] subsets= new DataSet[10];
//        int size=data.size();
//        double entropy=getEntropy(attr);
//        System.out.println("Get Entropy on "+attr.getName()+": "+entropy);
//        double gainedValue=entropy;
//        for(int i=0; i<attr.getN(); i++){
//            subsets[i]=new DataSet();
//            for(int j=0; j<data.size(); j++){
//                if(attr.getValue(i).equals(data.get(j).getValueForAttribute(attr)))subsets[i].add(data.get(j));
//            }
//            gainedValue=gainedValue-((subsets[i].size()/size)*subsets[i].getEntropy(goal));
//        }
//        System.out.println("Gained Value:"+gainedValue);
//        return gainedValue;
          double entropy=getEntropyOfSet();
          double gainedValue=entropy;
          for(int i=0; i<attr.getN(); i++){
              double weight=(double)count(attr, attr.getValue(i))/data.size();
              entropy=getEntropy(attr, attr.getValue(i));
              gainedValue=gainedValue-(entropy*weight);
          }
          return gainedValue;
    }
    
    public Attribute bestSplit(){
        double max, aux;
        Attribute attr=null;
        max=0;
        for(int i=0; i<data.get(0).attributes.size(); i++){
            aux=gainedValue(data.get(0).attributes.get(i).getAttribute());
            if(aux>max){
                max=aux;
                attr=data.get(0).attributes.get(i).getAttribute();
            }
        }
        return attr;
    }
    
    public void deleteAttribute(Attribute attr){
        for(int i=0; i<data.size(); i++){
            data.get(i).deleteAttribute(attr);
        }
    }
    
    public void add(Data data){
        goal=data.getGoal().getAttribute();
        this.data.add(data);
    }
    
    public void delete(int n){
        data.remove(n);
    }
    
    public int size(){
        return data.size();
    }
    
    public boolean isPure(){
        if(data.isEmpty() || data.size()==1)return true;
        String value=data.get(0).getGoal().getValue();
        for(int i=1; i<data.size(); i++){
            String aux=data.get(i).getGoal().getValue();
            if(!value.equals(aux))return false;
        }
        
        return true;
    }
    
    public Data get(int i){
        return data.get(i);
    }
    
    public void debugPrint(){
        for(int i=0; i<data.size(); i++){
            System.out.print(data.get(i).goal.getValue()+" ");
        }
    }
//    public DataSet split(){
//                
//    }
}
