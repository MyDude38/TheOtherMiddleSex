package serverclient;

public class threeDShapes extends Shapes //implements Serializable
{
     public int height;
     public int radius;
    
    public threeDShapes(int noOfSides, String name)
    {
        super(name, noOfSides);
    }
    
    public void set_height(int x)// this mutator takes an input and puts it in height
        {
                height = x;
        }
    
    public void set_radius(int y)// this mutator takes an input and puts it in radius
        {
                radius = y;
        }
    
    public double get_Area_Cylinder() {
        double Area = 2 * Math.PI * radius * (radius + height);
        return Area;
    }
    
    public double get_Area_Sphere() {
       double Area = 4 * Math.PI * Math.pow(radius, 2);
       return Area;
    }
    
    public double get_Volume_Cylinder() {
      double Volume = Math.PI * radius * radius * height;
      return Volume;
    }
    
    public double get_Volume_Sphere() {
        double Volume =  (4 * Math.PI * Math.pow(radius, 3)) / 3;
        return Volume;
    }
}
