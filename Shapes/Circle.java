/*  Sahil Gupta
    Stutler
    APCSA
    Shapes Lab - Use interfaces and OOP to create
      programs to find the area and perimeter of certain shapes */

public class Circle implements Shape, Object{ //class ceclaration with implementation of interface
   
   //fields for class
   private double radius; 
   private String name;
   
   public Circle(double radius, String name){ //constructor
      this.radius = radius;
      this.name = name;
   }
   
   public double getPerimeter(){ //get perimeter or in this case circumference
      return (2 * Math.PI * this.radius);
   }
   
   public double getArea(){ //get the area 
      return (Math.PI) * (this.radius * this.radius);
   }
   
   public String getInfo(){ //get the overall info
      return getName() + "  perimeter: " + getPerimeter() + "  area: " + getArea();
   }

   public String getName(){ //get the name of the shape
      return this.name;
   }

   public boolean equals(Shape shape){ //compare the shape with another shape
      boolean isEqual = false;
      if(shape.getArea() == getArea()){
          if(shape.getPerimeter() == getArea()){
              isEqual = true;
          }
      }
      return isEqual;
  }
}