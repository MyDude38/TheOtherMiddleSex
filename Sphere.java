package versioncontrollab;

public class Sphere extends threeDShapes 
{
    
    public  double radius;
    public String Name;
    public int noOfSides;
    
    public Sphere(String name, int numberofsides, int radius)
    {
        super(1, name);
        this.noOfSides = numberofsides;
        this.Name = name;
        this.radius = radius;

    }
    
    public double get_Area_Sphere() {
       double Area = 4 * Math.PI * Math.pow(radius, 2);
       return Area;
    }
    
    public double get_Volume_Sphere() {
        double Volume =  (4 * Math.PI * Math.pow(radius, 3)) / 3;
        return Volume;
    }
}
