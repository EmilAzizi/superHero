import database.Database;

public class UserInterface {

    Database DB;
    Controller controller;

    public UserInterface(){
        DB = new Database();
        controller = new Controller(DB);
    }

    public void startProgram(){
        controller.run();
    }
}
