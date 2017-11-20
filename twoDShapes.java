package serverclient;

public class twoDShapes extends Shapes //implements Serializable
{
    public int height;
    public int width;
    
    public twoDShapes(int noOfSides, String name)
    {
        super(name, noOfSides);
    }
    public void set_height(int x)// this mutator takes an input and puts it in height
        {
                height = x;
        }
    public void set_width(int y)// this mutator takes an input and puts it in height
        {
        
                width = y;
        }
    
    /**
     *
     * @return
     */
    public double get_Area() {
        double Area = height * width;
        return Area;
    }
   
    public double get_Perimeter() {
        double Perimeter = (height*2) + (width*2);
        return Perimeter;
    }
    
}
