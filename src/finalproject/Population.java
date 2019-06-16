/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author Anshika
 */
public class Population {
     Individual[] individuals;
private double FitestFitness;
    /*
     * Constructors
     */
    // Create a population
    public Population(int populationSize, boolean initialise,int features) {
         FitestFitness=0.0;
        individuals = new Individual[populationSize];
        // Initialise population
        if (initialise) {
            // Loop and create individuals
            for (int i = 0; i < populationSize; i++) {
                Individual newIndividual = new Individual(features);
                newIndividual.generateIndividual();
                saveIndividual(i, newIndividual);
            }
        }
    }

    /* Getters */
    public Individual getIndividual(int index) {
        return individuals[index];
    }

    public Individual getFittest() throws Exception {
        Individual fittest = individuals[0];
       // System.out.println("getfittest start");
      //  double f1=0,f2=0;
        
     /*     f2=fittest.getFitness();
         
         FitestFitness=f2;
        // Loop through individuals to find fittest
        for (int i = 1; i < size(); i++) {
           f1= individuals[i].getFitness();
          
            
            if (f2 <= f1) {
               // fittest = getIndividual(i);
               fittest=individuals[i];
                FitestFitness=f1;
                f2=f1;
                
            }
            
               //System.out.println("getfittest going on ");
        }
       */ 
       // System.out.println("getfittest complete");
       
       
        FitestFitness=fittest.getFitness();
        for (int i = 0; i < size(); i++) {
           
           double ff=getIndividual(i).getFitness();
            if (  FitestFitness <=ff ) {
                fittest = getIndividual(i);
                FitestFitness=ff;
            }
        }
        return fittest;
    }
    
    public double getFittestFitness(){
        return FitestFitness;
    }
    
    
    

    /* Public methods */
    // Get population size
    public int size() {
        return individuals.length;
    }

    // Save individual
    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }
}
