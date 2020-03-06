public abstract class Triangle implements Shape{
   private double base;
   private double sideOne;
   private double sideTwo;
   
   public Triangle(double base, double sideOne, double sideTwo){
      this.base = base;
      this.sideOne = sideOne;
      this.sideTwo = sideTwo;
   }
   
   public double getPerimeter(){
      return this.base + this.sideOne + this.sideTwo;
   }
   
   public double getArea(){
      
   }
}