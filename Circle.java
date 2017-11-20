package versioncontrollab;

public class Circle extends twoDShapes //implements Serializable
{
    private int Number_of_sides;
    private double radius;
    private String Name;
    
    private Circle(String name, int numberofsides, int radius)
    {
        super(1, name);
        this.Number_of_sides = numberofsides;
        this.Name = name;
        this.radius = radius;
        
        
    }
    
    private void Set_radius(int y)
    {
        radius = y;
    }
    
    @Override
    public double get_Area()
    {
        double Area = Math.PI * radius * radius;;
        return Area;
    }
    
    public double get_Perimeter()
    {
        double perimeter = Math.PI * (radius * 2);
        return perimeter;
    }
}
