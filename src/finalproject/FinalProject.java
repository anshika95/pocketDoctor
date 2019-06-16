/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.IOException;


/**
 *
 * @author Anshika
 */
public class FinalProject {

 // cut and paste this one in the main  
    public static void main(String[] args)throws Exception{
        // TODO code application logic here
        
        int i=1;
        
        
    
       Disease d1=new Disease();
    //breast cancer   
  if(i==1)    {
 d1.loaddata(1);}
 /* 
  //diabetes
   if(i==2)   { 
 d1.loaddata(2);}
   
   //heart disease
    if(i==3)  {  
 d1.loaddata(3);}
    
    //liver disorder
     if(i==4)  {  
 d1.loaddata(4);}
     
     //parkinson data
      if(i==5)  {  
 d1.loaddata(5);
      }
      
 */       
    
       
 System.out.println("loading complete");
//nlysvm(d1);
gasvm(d1);
 
     
 
   
   
   
   
   
  
        
        
        
        
    }
    
    public static void onlysvm(Disease d1) throws IOException{
         int j,seed=0;
         double z;
         z=0.50;
      double acc,split=0.0,max=50.0;
        for(int i=1;i<10;i++){
            
            for(j=0;j<41;j++){//split
                System.out.println("for split"+(z+j*0.01));
            System.out.println("for seed " + i);
        d1.sampling((z+j*0.01), i);
        
        
        //if only svm
        d1.svmtrain();
     acc=   d1.accuracypredict();
     
     if(acc>max){
         max=acc;
         seed=i;
         split=(z+j*0.01);
     }
       
         System.out.println("svm only train complete----------------------------------------");
         
            }
            
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        
     System.out.println("max accuracy is "+ max );
        System.out.println("seed is "+ seed );
           System.out.println("split is "+ split );
     
       
 
 
    
    }
    
    public static void gasvm(Disease d1) throws IOException, Exception{
         int i;
       int j;
     double z=0.75;
     for(j=0;j<1;j++){  //4-5.0.80
    for(i=1;i<10;i++){//seed (1-9)
     
   d1.sampling(z+(j*0.01),i);
    // if hybrid svm
      d1.hybrid();
     System.out.println("seed "+ i + "split = "+ (z+(j*0.01)));
   System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    
     System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
      System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
     }
    }
    
    
}
