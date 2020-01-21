import java.util.ArrayList;

public class SolarSystem{
    private ArrayList<String> planetList = new ArrayList<String>();
    private ArrayList<Planet> objectList = new ArrayList<Planet>();
    
    public void getObject(Planet name){
        objectList.add(name);
     }

    public void addPlanet(String name){
        planetList.add(name);
    }

    public String planetPrint(){
        String output = "Solar System of Sayhil contains Planets:  \n";
        for(int i = 0; i < planetList.size(); i++){
            output += planetList.get(i) + "\n";
        }
        return output;
    }
    
    public String getClosestPlanet(){
        double closest = 0; 
        int min = 0;
    	double[] orbitalArray = new double[objectList.size()];
    	for(int i = 0; i < orbitalArray.length; i++) {
    		orbitalArray[i] = objectList.get(i).getOrbitalRadius();
        }
        closest = orbitalArray[0];
        for(int i = 1; i < orbitalArray.length; i++){
            if(closest > orbitalArray[i]){
                min = i;
                closest = orbitalArray[i];
            }
        }
        String output = "The Planet that is Closest to the Sun is " + objectList.get(min).getName() + " with a orbital radius of " + orbitalArray[min];
        return output;
    }
}