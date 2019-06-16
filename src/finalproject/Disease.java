/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import be.abeel.util.Pair;
import java.io.File;
import java.io.IOException;
import libsvm.LibSVM;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.filter.normalize.NormalizeMidrange;
import net.sf.javaml.sampling.Sampling;
import net.sf.javaml.tools.data.ARFFHandler;
import net.sf.javaml.tools.data.FileHandler;

/**
 *
 * @author Anshika
 */
public class Disease {
    
   private Dataset data;
   private Dataset train;
   private  Dataset test;
 //  private Dataset cross;
   private int i;
   private Classifier svm;
   private double accuracy;
//   public Fitnesscal f1;
   //private Individual individual;
    
    public void loaddata(int i)throws Exception{
        this.i=i;
        if(i==1){
           // data= ARFFHandler.loadARFF(new File("breast-cancer.arff"), 9);
             data = FileHandler.loadDataset(new File("bcancer.txt"), 10, ",");
        }
        
        
        if(i==2){
           // data= ARFFHandler.loadARFF(new File("diabetes.arff"),8);
            data = FileHandler.loadDataset(new File("diabetes.txt"),8, ",");
        }
        
        if(i==3){
             data = FileHandler.loadDataset(new File("heart.txt"),13, ",");
        }
        
        
         if(i==4){
              data= ARFFHandler.loadARFF(new File("liver.arff"),6);
        }
         
          if(i==5){
             data = FileHandler.loadDataset(new File("parkinson.txt"),17, ",");
        }
        
    }
    
    
        
public void sampling( double split,int seed) throws IOException{
    
      NormalizeMidrange n=new NormalizeMidrange();
       n.build(data);
       
       n.filter(data);
    FileHandler.exportDataset(data,new File("output.txt"));
    data = FileHandler.loadDataset(new File("output.txt"), 0,"\t");
     Sampling s=Sampling.SubSampling;
       
      
       
   // Pair<Dataset,Dataset>datac=s.sample(data,(int)(data.size()*0.90),2);
    // cross=datac.y();
    //Dataset data1=datac.x();
    
     Pair<Dataset, Dataset> datas=s.sample(data, (int)(data.size()*split),seed);
       
       //20 percent test data
       
       //load cross into file crossout.txt
        // FileHandler.exportDataset(cross,new File("cross.txt"));
       
       
       
        train=datas.x();
        test=datas.y();
}

    

public Dataset getTraindata(){
    return train;
}

public Dataset getTestdata(){
    return train;
}




public void svmtrain(){
    
      svm=new LibSVM();
       svm.buildClassifier(train);
    
}

public double accuracypredict(){
    
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
    
    accuracy=(correct*1.0/(correct+wrong))*100;
   System.out.println("correct="+correct);
   System.out.println("wrong="+wrong);
     
    //if(accuracy>79.01)
      System.out.println("accuracy"+accuracy);
      return accuracy;
     
}



   
    public void hybrid()throws Exception{
        
        int m=0;
      //  f1=new Fitnesscal();
        if(i==1){
     // Set a candidate solution
     m=10;
    
     
        Fitnesscal.setSolution("0101100000",train,test,m);
        
        }
        
        
        
        if(i==2){
         m=8;   
        
        Fitnesscal.setSolution("11101101",train,test,m);
        
        }
        
         if(i==3){
         m=13;   
        
        Fitnesscal.setSolution("100100110110",train,test,m);
        
        }
           if(i==4){
         m=6;   
        
        Fitnesscal.setSolution("100101",train,test,m);
        
        }
         
         if(i==5){
         m=23;   
        
        Fitnesscal.setSolution("10010100011100110011110",train,test,m);
        
        }
        
        
        Population myPop = new Population(20,true,m);
        System.out.println("population created");
        // Evolve our population until we reach an optimum solution
        int generationCount = 0;
       Individual i11=new Individual(m);
       i11=myPop.getFittest();
         System.out.println("get fittest out of the population created");
         
         //instead of f1 write fitnesscal
         
        while (myPop.getFittestFitness() < Fitnesscal.getMaxFitness() && generationCount<20) {
            generationCount++;
        //    System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittestFitness());
            
            
            
            
        
            
            
            myPop = Algorithm.evolvePopulation(myPop,m);
             i11=myPop.getFittest();
              System.out.println("Generation: " + generationCount);
        System.out.println("Genes:");
        System.out.println(i11);
        
        
        ////////////////////////////////////
        
        int y,gn,nn=0;
        for(gn=0;gn<m;gn++){
            y=i11.getGene(gn);
            if(y==1) nn++;
        }
        
        
        
         System.out.println("number of genes is "+nn);
        
         System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittestFitness());
        
        
        
        }
        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
        System.out.println("Genes:");
        System.out.println(myPop.getFittest());
        
    }
   
    
}
