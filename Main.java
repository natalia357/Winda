import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args){

        Engine engine = new Engine(16);
        ArrayList<Elevator> elevators = engine.getElevators();
        Random generator = new Random();
        for(Elevator e : elevators)
        {  int x = generator.nextInt(10)+1;
            e.PickUp(x);
            System.out.println(e.Status());
            System.out.println("------- Next Elevator info: -------");
        }
    }

}
