import java.util.ArrayList;
import java.util.Random;

public class Elevator {

    private int currentFloor;
    ArrayList<Integer> floors;
    Random generator;
    private final String name;
    private final int numberOfFloors;
    private int destination;
    private final int numberOfPeopleMax;
    int[] dest;

    public Elevator(String name, int destination) {
        this.destination =destination;
        this.name=name;
        this.numberOfPeopleMax = 6;
        this.numberOfFloors = 10;
        this.dest = new int[this.numberOfFloors+1];
        this.generator = new Random();
    }

    public int randomDestination(int currentFloor){
        int x = generator.nextInt(numberOfFloors) + 1;
        while (x == currentFloor)x = generator.nextInt(numberOfFloors)+1;
        return x;
    }


    public int getDestination() {
        return destination;
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
    public String getName() { return name; }
    public String Status(){
        return "Name: "+getName()+" "+ "CurrentFloor:"+getCurrentFloor()+" "+"Destination "+getDestination();
    }

    public void PickUp(int currentFloor){
        floors = new ArrayList<>();
        int i = 0;
        while(i < numberOfPeopleMax){
            int floor = chooseFloor(i,currentFloor);
            if(!floors.contains(floor))floors.add(floor);
            i += 1;
        }
        this.currentFloor = currentFloor;
        upDate(currentFloor);
    }

    public int chooseFloor(int person, int currentFloor){
            int floor = randomDestination(currentFloor);
            System.out.println("Passanger nr " + (person + 1)+ "enter floor: "+ floor);
            this.dest[floor] += 1;
        return floor;
    }


    public int up(){
        System.out.println("Up");
        return this.currentFloor += 1;

    }
    public int down(){
        System.out.println("Down");
        return this.currentFloor -= 1;
    }

    public int route(int currentFloor){
        int way = Math.abs(currentFloor-floors.get(0));
        int index = 0;
        int i = 2;
        while(i < floors.size()){
            if(way > Math.abs(currentFloor - floors.get(i))){
                way = Math.abs(currentFloor - floors.get(i));
                index = i;
            }
            i += 1;
        }
        way = floors.get(index);
        floors.set(index, 100);
        return way;
    }

    public void upDate(int actualFloor){
        int x = this.floors.get(0);
        this.destination = x;
       System.out.println(this.Status());
        while(actualFloor < x){
            actualFloor = up();
        }
        while(actualFloor > x){
            actualFloor = down();
        }
        System.out.println("Floor: "+ x +" Number of passangers who are getting: "+ dest[x]);
        this.dest[x] = 0;
        this.currentFloor = x;
        for(int i = 1; i < floors.size(); i++){
            x = route(actualFloor);
            this.destination = x;
            System.out.println(Status());
            while(actualFloor < x){
                actualFloor = up();
            }
            while(actualFloor > x){
                actualFloor = down();
            }
            System.out.println("Floor: "+ x +" Number of passangers who are getting: "+ dest[x]);
            this.currentFloor = x;
        }
    }

}
