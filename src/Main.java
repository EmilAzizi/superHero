import database.Database;
public class Main {
    public static void main(String[] args) {
        Database DB = new Database();
        Controller controller = new Controller(DB);
        controller.run();
    }
}