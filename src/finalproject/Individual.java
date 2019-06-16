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
public class Individual {
    public byte[] genes;
    
    private double fitness = 0.0;
    
      public Individual(int length){
    
    genes=new byte[length];
    
    
    }

    // Create a random individual
    public void generateIndividual() {
        for (int i = 0; i < size(); i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }
    }

    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths
   // public  void setDefaultGeneLength(int length) {
    //    defaultGeneLength = length;
    //}
    
    public byte getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, byte value) {
        genes[index] = value;
        fitness = 0.0;
    }

    /* Public methods */
    public int size() {
        return genes.length;
    }

    public double getFitness()throws Exception {
       if (fitness == 0.0) {
          //  System.out.println("in individual getfitness");
            fitness = Fitnesscal.getFitness(this);
         
       }
        return fitness;
    }

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }
    
}
