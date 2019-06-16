/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import libsvm.LibSVM;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.tools.data.FileHandler;

/**
 *
 * @author Anshika
 */
public class Fitnesscal {
    
    
   static   byte[] solution;
    static   Dataset train1;
    static  Dataset test1;
    static Dataset cross;
    static   int m;
   //  static   Dataset optimalData;
   //  static   Dataset optimalTest;
   //  static Dataset traincopy;
   //  static Dataset testcopy;

    /* Public methods */
    // Set a candidate solution as a byte array
    
    
     
    static  void setSolution(byte[] newSolution,Dataset t1,Dataset t2,int i) throws Exception {
        solution =new byte[newSolution.length];
        solution=newSolution;
       // train1= t1;
       // test1=t2;
        m=i;
        train1=new DefaultDataset();
        test1=new DefaultDataset();
        
        t1.forEach((inst) -> {
            train1.add(inst);
       });
        t2.forEach((inst) -> {
            test1.add(inst);
       }); //  optimalData=train1;
       //
       FileHandler.exportDataset(train1,new File("train.txt"));
       FileHandler.exportDataset(test1,new File("text.txt"));
        
        
        
       // traincopy=t1.copy();
       // testcopy=t2.copy();
    }

    // To make it easier we can use this method to set our candidate solution 
    // with string of 0s and 1s
  static     void setSolution(String newSolution,Dataset t1,Dataset t2,int j)throws Exception {
        solution = new byte[newSolution.length()];
        // Loop through each character of our string and save it in our byte 
        // array
        for (int i = 0; i < newSolution.length(); i++) {
            String character = newSolution.substring(i, i + 1);
            if (character.contains("0") || character.contains("1")) {
                solution[i] = Byte.parseByte(character);
            } else {
                solution[i] = 0;
            }
        }
         train1=new DefaultDataset();
        test1=new DefaultDataset();
        
         
        t1.forEach((inst) -> {
            train1.add(inst);
       });
        t2.forEach((inst) -> {
            test1.add(inst);
       });
        FileHandler.exportDataset(train1,new File("train.txt"));
       FileHandler.exportDataset(test1,new File("test.txt"));
        
        
        // train1= t1;
        //f.fcftest1=t2;
        m=j;
    }
    
    
   static  double getFitness(Individual i1) throws Exception{
        double fitness = 0.0;
        // Loop through our individuals genes and compare them to our cadidates
       // for (int i = 0; i < individual.size() && i < solution.length; i++) {
         //   if (individual.getGene(i) == solution[i]) {
                //fitness++;
           // }
       // }
     /*  FitnessFunc ff=new FitnessFunc();
       System.out.println("in getfitness function of fitnesscal");
         try {
             fitness=ff.calculatefv(m,individual,train,test);
         } catch (Exception ex) {
             Logger.getLogger(Fitnesscal.class.getName()).log(Level.SEVERE, null, ex);
         }
        System.out.println("fv");
        System.out.println(fitness);
      //  ff=null;*/
     
     
     int n1=0;
       int x;
        
        for(x=0;x<m;x++){
            if(i1.genes[x]==1) n1++;
        }
     //   System.out.println("optimal phase 1"); 
        int z=0,y=0;
        
        int[] index1;
        
       index1 = new int[m-n1];
        
        for(z=0;z<m;z++){
            if(i1.getGene(z)==(byte)0) {
                index1[y]=z;
                y++;
            
            }
            
        }
        //System.out.println("optimal phase 2");
     
        //---------------------------------------------------------------------------------
        
        /*
        int i=0;
        
      int []  index=new int[y];
      
      
        for(i=0;i<y;i++){
            index[i]=index1[i];
        }
        //----------------------------------------------------------------------
       */ 
        // System.out.println("optimal phase 3");
         
        
      //    Set<Integer>set=new HashSet<>();
      //    Set<Integer>set1=new HashSet<>();
          
    //  for( i = 0; i <y; i++) 
    //  { set.add(index[i]);
      
    //  set1.add(index[i]);
    //  }
      
      
   //---------------------------------------------------------------------------------     System.out.println("optimal phase x1");
     // a.add(index[0]);
      //a.add(index[1]);
     // a.add(index[2]);
     // optimalData.forEach((Instance inst) -> {
       //   inst.removeAttributes(set);
       // });
       
       
    //  Dataset optimalData = new DefaultDataset();
    //   Dataset optimalTest = new DefaultDataset();
       
   
 
   
    /*    train1.forEach((inst) -> {
            optimalData.add(inst);
       });
        test1.forEach((inst) -> {
            optimalTest.add(inst);
       }); //  optimalData=train1;
       //  optimalTest=test1;
       
       
      */ 
       
       
       
       
    /*   int flag=y;
       int setindex;
    //   setindex=indexOf(set);
       if(flag>0){
      for (Instance inst : optimalData)
      { inst.removeAttributes(set);
      
      flag--;
      }
       }   
      flag=y;
      set.clear();
     if( flag>0)
     { for (Instance inst : optimalTest)
        {   inst.removeAttributes(set1);   
        flag--;
        
      } 
       set1.clear();
     }   
     
   //  optimalData=train1;
    //   optimalTest=test1;
       
      
      
      
     //  optimalTest.forEach((inst)->{
     //     inst.removeAttributes(set);
        
  //  });
       
     */  
   //   System.out.println("optimal phase 4");
     
     Dataset   optimalData=FileHandler.loadDataset(new File("train.txt"), 0,"\t");
      Dataset  optimalTest=FileHandler.loadDataset(new File("test.txt"), 0,"\t");
                
            //cross=FileHandler.loadDataset(new File("cross.txt"),0,"\t");    
   ////////////////////////////////////////////////////////////////////// System.out.println("optimal phase x2");
    
    
    int temp;
    
      for(Instance inst:optimalData)
      {
           for(temp=y-1;temp>=0;temp--){
                inst.removeAttribute(index1[temp]);
           }
      }
   // temp=0;
     for(Instance inst:optimalTest)
      {
           for(temp=y-1;temp>=0;temp--){
                inst.removeAttribute(index1[temp]);
           }
      }
    
    
   
   
    
  
    
    Classifier svm=new LibSVM();
       svm.buildClassifier(optimalData);
      
    int correct = 0, wrong = 0;
/* Classify all instances and check with the correct class values */
for (Instance inst : optimalTest) {
    Object predictedClassValue = svm.classify(inst);
    Object realClassValue = inst.classValue();
    if (predictedClassValue.equals(realClassValue))
        correct++;
    else
        wrong++;
    
}  
     double acc;
    
    acc=(correct*1.0/(correct+wrong))*100;
  //System.out.println("correct="+correct);
  // System.out.println("wrong="+wrong);
   if(acc>94.33)////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      System.out.println("accuracy"+acc);
   
       optimalData.clear();
       optimalTest.clear();
        
     //   svm=null;
      
        fitness=acc;
        return fitness;
    }
    
      // Get optimum fitness
  static    double getMaxFitness() {
       double maxFitness = 100;
        return maxFitness;
       
    }
  
    
    
    
    
    
    
    
    
}
