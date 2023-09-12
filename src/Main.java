import avengersLeague.AvengersLeague;
public class Main {
    public static void main(String[] args) {
        AvengersLeague AL = new AvengersLeague();
        Controller controller = new Controller(AL);
        controller.run();
    }
}