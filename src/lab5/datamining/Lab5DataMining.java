/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.datamining;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author juanp
 */
public class Lab5DataMining {
    
    static final String ATTRIBUTE="@attribute";
    static final String RELATION="@relation";
    static final String DATA="@data";
    static final String COMMENT="%";
    static final String SEPARATOR=",";

    /**
     * @param args the command line arguments
     */
    static LinkedList<Attribute> attributeList=new LinkedList();
    static DataSet dataset=new DataSet();
    static TreeNode root;
    static String[] data = new String[999];
    static String[] attributes = new String[99];
    static int size, attr;
    public static void parseInput(){


    }
    
    
    public static void output(TreeNode root){
        if(root.isLeaf()){
            System.out.println("ANSWER: "+root.getValue());
        }else{
            for(int i=0; i<root.attribute.getN(); i++){//iterar sobre los posibles valores de cada atributo
                System.out.println(root.attribute.getName()+": "+root.attribute.getValue(i));
                output(root.getChild(i));
            }
        }
    }
    String aux=new String();
    
    public static void main(String[] args) throws InterruptedException, Throwable {
        // TODO code application logic here
        int op, cl;
        Scanner input=new Scanner(System.in);
//        String relation=input.nextLine();
//        Parser parser = new Parser();
        input=null;
        Thread thread=new Thread(new Parser());
        thread.start();

        Pattern pattern = Pattern.compile("\\s([A-Za-z]+)");
        Matcher matcher;

        String attrName;
        String subStr;
        String[] values;
        Thread.sleep(3000);
        
        for(int i=0; i<attr; i++){
            op=attributes[i].indexOf("{")+1;
            cl=attributes[i].indexOf("}");
//            matcher = pattern.matcher(attributes[i]);
//            attrName=matcher.group(1);
            attrName=attributes[i].substring(ATTRIBUTE.length(), op-2);
            subStr=attributes[i].substring(op, cl);
            attributeList.add(new Attribute(attrName, subStr.split(SEPARATOR+" ")));
        }
        
        String[] aux=new String[attributeList.size()];
        
        for(int i=0; i<size; i++){
            aux=data[i].split(SEPARATOR);
            dataset.add(new Data(aux));
        }
        
        root=new TreeNode(0, dataset, null);
        root.split();
        root.print();
        System.exit(0);

        return;
    }
    
}
