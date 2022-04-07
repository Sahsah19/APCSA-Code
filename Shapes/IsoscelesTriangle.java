/*  Sahil Gupta
    Stutler
    APCSA
    Shapes Lab - Use interfaces and OOP to create
      programs to find the area and perimeter of certain shapes */

public class IsoscelesTriangle extends Triangle{ //class declaration with extension of superclass

    public IsoscelesTriangle(double base, double side, String name){ //constructor connecting to superclass
        super(base, side, side, name);
    }

    public String getInfo(){ //get info of the shape
        return getName() + "  perimeter: " + getPerimeter() + "  area: " + getArea();
    }
}