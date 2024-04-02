import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Fighter marc = new Fighter("marc",15,100,85,1);
        Fighter alex = new Fighter("alex",10,100,90,5);
        Ring r = new Ring(alex,marc,85,105);
        r.run();
    }
}


