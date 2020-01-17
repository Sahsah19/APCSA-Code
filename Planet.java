public class Planet{
   private String name;
   private int age;
   private String color;
   private double mass;
   private double orbitalRadius;
   private double diameter;
   
   public Planet(String name, int age, String color, double mass, double orbitalRadius, double diameter){
      this.name = name;
      this.age = age;
      this.color = color;
      this.mass = mass;
      this.orbitalRadius = orbitalRadius;
      this.diameter = diameter; 
   }
   
   public String planetInfo(){
      String info = "Here is some information about Planet " + this.name + ":\n   "
          + this.name + " 
   }
}