public class Lanterns{
    public static void t(){
        System.out.println("    *****\n  **********\n*************");
    }
    
    public static void m(){
        System.out.println("* | | | | | *");
    }
    
    public static void bb(){
        System.out.println("*************");
    }
    
    public static void sb(){
        System.out.println("    *****");
    }
    
    public static void sp(){
        System.out.println();
    }
    
    public static void main(String[] args){
        t();
        sp();
        t();
        m();
        bb();
        t();
        sp();
        t();
        sb();
        m();
        m();
        sb();
        sb();
    }
}