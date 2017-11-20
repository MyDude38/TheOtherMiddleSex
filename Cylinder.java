package versioncontrollab;

public class Cylinder extends threeDShapes 
{
    
    public int Number_of_sides;
    public String Name;
    public  double radius;
    public  double height;
    
    public Cylinder( String name,int numberofsides, double height, double radius)
    {
        super(4, name);
        this.Number_of_sides = numberofsides;
        this.Name = name;
        this.height = height;
        this.radius = radius;

    }

     public double get_Area_Cylinder() {
        double Area = 2 * Math.PI * radius * (radius + height);
        return Area;
    }
    
    public double get_Volume_Cylinder() {
      double Volume = Math.PI * radius * radius * height;
      return Volume;
    }
    
}
