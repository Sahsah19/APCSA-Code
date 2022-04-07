/*  Sahil Gupta
    Stutler
    APCSA
    Shapes Lab - Use interfaces and OOP to create
      programs to find the area and perimeter of certain shapes */

public class Square extends Rectangle{ //square class declaration with extension to rectangle superclass
   
   public Square(double side, String name){ //constructor to bounce back of superclass
      super(side, side, name);
   }
   
   public String getInfo(){ //get info of square
      return getName() + "  perimeter: " + getPerimeter() + "  area: " + getArea();
   }

}