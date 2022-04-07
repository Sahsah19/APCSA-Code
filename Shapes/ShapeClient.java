import java.util.*; //import statement

/*  Sahil Gupta
    Stutler
    APCSA
    Shapes Lab - Use interfaces and OOP to create
      programs to find the area and perimeter of certain shapes */

      public class ShapeClient{ //class delcaration

   public static void main(String[] args){ //main method

      ArrayList<Shape> shapeList = new ArrayList<Shape>(); //arraylist declaration
      
      //try block to catch exceptions
      try{
         //start declaring objects
         Circle cir1 = new Circle(2.6, "Circle 1");
         Circle cir2 = new Circle(6.3, "Circle 2");
         Rectangle rec1 = new Rectangle(9.4, 6.2, "Rectangle 1");
         Rectangle rec2 = new Rectangle(8.4, 6.8, "Rectangle 2");
         Square sqr1 = new Square(3.6, "Square 1");
         Square sqr2 = new Square(6.1, "Square 2");
         ScaleneTriangle stri1 = new ScaleneTriangle(3.4, 3.9, 6.3, "ScaleneTriangle 1");
         ScaleneTriangle stri2 = new ScaleneTriangle(5.9, 8.3, 10.5, "ScaleneTriangle 2");
         IsoscelesTriangle itri1 = new IsoscelesTriangle(7.4, 4.8, "IsoscelesTriangle 1");
         IsoscelesTriangle itri2 = new IsoscelesTriangle(9.8, 7.5, "IsoscelesTriangle 2");
         EquilateralTriangle etri1 = new EquilateralTriangle(4.9, "EquilateralTriangle 1");
         EquilateralTriangle etri2 = new EquilateralTriangle(5.4, "EquilateralTriangle 2");
         RightTriangle rtri1 = new RightTriangle(4.2, 5.7, 8.9, "RightTriangle 1");
         RightTriangle rtri2 = new RightTriangle(6.9, 7.2, 10.7, "RightTriangle 2");
      
         //add all objects to arraylist
         shapeList.add(cir1);
         shapeList.add(cir2);
         shapeList.add(rec1);
         shapeList.add(rec2);
         shapeList.add(sqr1);
         shapeList.add(sqr2);
         shapeList.add(stri1);
         shapeList.add(stri2);
         shapeList.add(itri1);
         shapeList.add(itri2);
         shapeList.add(etri1);
         shapeList.add(etri2);
         shapeList.add(rtri1);
         shapeList.add(rtri1);

         //print out all the info
         System.out.println(cir1.getInfo());
         System.out.println(cir2.getInfo());
         System.out.println(rec1.getInfo());
         System.out.println(rec2.getInfo());
         System.out.println(sqr1.getInfo());
         System.out.println(sqr2.getInfo());
         System.out.println(stri1.getInfo());
         System.out.println(stri2.getInfo());
         System.out.println(itri1.getInfo());
         System.out.println(itri2.getInfo());
         System.out.println(etri1.getInfo());
         System.out.println(etri2.getInfo());
         System.out.println(rtri1.getInfo());
         System.out.println(rtri2.getInfo());
 

         //print the smallest and largest areas
         System.out.println(getSmallestArea(shapeList) + " has the Smallest Area of all the Shapes");
         System.out.println(getLargestArea(shapeList) + " has the Largest Area of all the Shapes");
      } catch(IllegalArgumentException e){ //catch block to catch invalid triangle
         System.out.println("Triangle has not been declared with proper dimensions: " + e.getMessage());
      }
   }

   public static String getSmallestArea(ArrayList<Shape> list){ //smallest area method
      double small = list.get(0).getArea();
      int whatShape = 0;
      for(int i = 1; i < list.size(); i++){
         if(list.get(i).getArea() < small){
            small = list.get(i).getArea();
            whatShape = i;
         }
      }
      return list.get(whatShape).getName(); //return name of smallest area shape
   }

   public static String getLargestArea(ArrayList<Shape> list){ //largest area method
      double large = list.get(0).getArea();
      int whatShape = 0;
      for(int i = 1; i < list.size(); i++){
         if(list.get(i).getArea() > large){
            large = list.get(i).getArea();
            whatShape = i;
         }
      }
      return list.get(whatShape).getName(); //return name of largest area shape
   }
}