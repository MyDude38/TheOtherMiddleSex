
package versioncontrollab;


public class Triangle extends twoDShapes 
{
    
    private int noOfSides;
    private int length;
    private int base;
    private int height;
    private String Name;
  
    
     public Triangle(String name,int numberofsides , int height, int base, int length)
    {
        super(3, name);
        this.noOfSides = numberofsides;
        this.Name = name;
        this.height = height;
        this.base = base;
        this.length = length;

    }

    public void set_length(int x)
        {
                length = x;
        }
    public void set_base(int y)
        {
                base = y;
        }
    public void set_height(int b)
        {
                height = b;
        }
    
    @Override
    public double get_Area()
    {
        double Area = (base * height) / 2;
        return Area;
    }
    
     @Override
    public double get_Perimeter()
    {
        double Perimeter = length + base + height;
        return Perimeter;
    }
    
    
    
}
