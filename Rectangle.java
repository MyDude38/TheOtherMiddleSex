package versioncontrollab;


public class Rectangle extends  twoDShapes //implements Serializable
{
  private int noOfSides;
  private double height;
  private double width;
  private String Name;
  
    public Rectangle( String name, int noOfSides, int height, int width)
    {
        super(4, name);
        this.noOfSides = noOfSides;
        this.Name = name;
        this.height = height;
        this.width = width;

    }

    public void set_height(int x)
        {
                height = x;
        }
    
    public void set_width(int y)
        {
                width = y;
        }
    
  @Override
    public double get_Area()
    {
        double Area = height * width;
        return Area;
    }
    
    @Override
    public double get_Perimeter()
    {
        double Perimeter = (height * width) * 2;
        return Perimeter;
    }

    
}
