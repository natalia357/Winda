import java.util.ArrayList;

public class Engine {
    public ArrayList<Elevator> getElevators() {
        return elevators;
    }


    public void setElevators(ArrayList<Elevator> elevators) {
        this.elevators = elevators;
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }

    private ArrayList<Elevator> elevators;

    private int n;

    public Engine(int n) {
        this.n = n;
        this.elevators = new ArrayList<>();
        int i = 0;
        while (i < this.n){
            Elevator e = new Elevator("A" + i , 10);
            this.elevators.add(e);
            i++;
        }
    }


    public ArrayList<String> giveStatus(ArrayList<Elevator> elevators){

        ArrayList<String> engine = new ArrayList<>();
        for(Elevator elevator : elevators)
        {
            engine.add(elevator.Status());
        }
        return engine;
    }


}
