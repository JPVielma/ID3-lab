/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.datamining;
import java.util.Scanner;
import static lab5.datamining.Lab5DataMining.*;

/**
 *
 * @author juanp
 */
public class Parser implements Runnable{

    @Override
    public void run() {
        String[] in = new String[999];
        String relation;
        Scanner input=new Scanner(System.in);
        attr=0;
        size=0;
        boolean aux;
        for(int i=0; true; i++){
            in[i]=input.nextLine();
            
            aux=false;
            for(int j=0; j<attr; j++){
                if(in[i].contains(attributes[j]))aux=true;
            }
            
            if(in[i].contains(RELATION)){
                relation=in[i];
            }
            else if(in[i].contains(ATTRIBUTE)){
                attributes[attr]=in[i];
                attr++;
            }
            else if(in[i].contains(DATA)||in[i].contains(COMMENT)){
                
            }
            else if(in[i].contains(",")){
                data[size]=in[i];
                size++;
            }
        }
    }
    
}
