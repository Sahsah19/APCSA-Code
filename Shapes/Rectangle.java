/*  Sahil Gupta
    Stutler
    APCSA
    Shapes Lab - Use interfaces and OOP to create
      programs to find the area and perimeter of certain shapes */

public class Rectangle implements Shape, Object{ //class declaration with interface implementation
   
   //field declarations
   private double width;
   private double length;
   private String name;

   public Rectangle(double width, double length, String name){ //constructor
      this.width = width;
      this.length = length;
      this.name = name;
   }
   
   public double getPerimeter(){ //get the perimeter of the rectangle
     return (this.width * 2) + (this.length * 2);
   }
   
   public double getArea(){ //get the area of the rectangle
      return this.width * this.length;
   }
   
   public String getInfo(){ //get info about the shape
      return getName() + "  perimeter: " + getPerimeter() + "  area: " + getArea();
   }

   public String getName(){ //get the name of the shape
      return this.name;
   }

   public boolean equals(Shape shape){ //equals method
      boolean isEqual = false;
      if(shape.getArea() == getArea()){
          if(shape.getPerimeter() == getPerimeter()){
              isEqual = true;
          }
      }
      return isEqual;
  }

}