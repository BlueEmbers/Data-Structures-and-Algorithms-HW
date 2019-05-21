package test;


import factories.NameFactory;
import factories.StudentFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import people.Name;
import utilities.CreateViewUtilNames;
import warehouse.NameWarehouse;

public class demo extends Application {
	static Name[] namesFromParam;
	public static void main(String[] args) {
		NameWarehouse wareHouse = new NameWarehouse();
		NameFactory factory = new NameFactory(wareHouse.getNames());
		namesFromParam = factory.getNamesFromParam();
		Application.launch(args);
		StudentFactory studentFactory = new StudentFactory(wareHouse.getNames());
		studentFactory.createStudentsUntilEnd();
	}

	public void start(Stage stage) throws Exception {
		stage = CreateViewUtilNames.createStage(namesFromParam);
		stage.show();
	}

}