package versioncontrollab;

 public abstract class Shapes{
        
 private int noOfSides;
 private String name;
 
 public int getNoOfSides()
 {
 return noOfSides;
 }
 
 public Shapes(String name, int noOfSides)
 {
 this.name = name;
 this.noOfSides = noOfSides;
 }
 
 public String getName()
 {
 return name;
 }
 
     public int getnoOfsides()
    {
        return noOfSides;
    }
}

