/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import libsvm.LibSVM;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.tools.data.FileHandler;

/**
 *
 * @author Anshika
 */
public class FitnessFunc {
    
     private static int n1;
    private static int[] index;
    private static Dataset optimalData;
    private static  Dataset optimalTest;
    private static double acc;
    
    public static void calculate_n1(Individual i1){
        
        
        n1=0;
        int x;
        
        for(x=0;x<i1.size();x++){
            if(i1.genes[x]==1) n1++;
        }
        
        
        //return n1;
        
    }
    
    private void getfeatureindexs(Individual i1){
        int x=0,y=0;
        
        int[] index1=new int[10];
        
        for(x=0;x<i1.size();x++){
            if(i1.getGene(x)==(byte)0) {
                index1[y]=x;
                y++;
            
            }
            
        }
       
        int i=0;
        index=new int[y];
        for(i=0;i<y;i++){
            index[i]=index1[i];
        }
      //  return index;
        // System.out.println(Arrays.toString(index));
    }
    
    
    private void getOptimalData(Dataset data,Dataset test)throws Exception{
       // Dataset optimalData=new DefaultDataset();
      //  Dataset temp;
       // boolean b;
       //optimalData=data;
          
      
      //  for(int i = 0; i < index.length; i++) 
           // set.add(index[i]);
         
         
         
     //  RemoveAttributes r=new RemoveAttributes(set);
        
      // for(Instance instance:optimalData){
          // r.filter(instance);
         // instance.removeAttributes(
          
               
      // }
      
      Set<Integer>set=new TreeSet<>();
      for(int i = 0; i < index.length; i++) 
            set.add(index[i]);
     // a.add(index[0]);
      //a.add(index[1]);
     // a.add(index[2]);
      data.forEach((inst)->{
          inst.removeAttributes(set);
        
    });
       test.forEach((inst)->{
          inst.removeAttributes(set);
        
    });
      System.out.println("optimal phase 1");
      optimalData =data;
      optimalTest=test;
       
       /* try {
            FileHandler.exportDataset(optimalData,new File("bb.txt"));
        } catch (IOException ex) {
            Logger.getLogger(FitnessFunc.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }
    
    
    private void calculateError(Dataset test){
        
      // classify c1=new classify();
       Classifier svm=new LibSVM();
       svm.buildClassifier(optimalData);
       
        
    
    int correct = 0, wrong = 0;
/* Classify all instances and check with the correct class values */
for (Instance inst : test) {
    Object predictedClassValue = svm.classify(inst);
    Object realClassValue = inst.classValue();
    if (predictedClassValue.equals(realClassValue))
        correct++;
    else
        wrong++;
    
}  
  //   double accuracy;
    
    acc=(correct*1.0/(correct+wrong))*100;
    System.out.println("correct="+correct);
     System.out.println("wrong="+wrong);
      System.out.println("accuracy"+acc);
    
    
    
}
      // error =c1.error(acc);
      // return error;
        
        
       
    
    public double calculatefv(int features,Individual i1,Dataset train,Dataset test)throws Exception{
        
       
        calculate_n1(i1);
         System.out.println("step 1");
        getfeatureindexs(i1);
         System.out.println("step 2");
        getOptimalData(train,test);
         System.out.println("step 3");
        calculateError(optimalTest);
         System.out.println("step 4");
        
       double fv;
      fv=acc/(features-n1);
        return acc;
    }
    
    
    
}
