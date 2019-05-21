package utilities;

import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import people.Name;

public class CreateViewUtilNames {
	private CreateViewUtilNames() {
	}
	public static Stage createStage(Name[] names) {
		Stage stage = new Stage();
		stage.setScene(createScene(names));
		stage.setTitle("Names From Paramaters");
		return stage;
	}
	private static Scene createScene(Name[] names) {
		Scene scene = new Scene(createTextArea(names),500,500);
		return scene;
	}
	private static TextArea createTextArea(Name[] names) {
		TextArea text = new TextArea();
		text.setEditable(false);
		for (int i = 0; i < names.length; i++) {
			text.appendText(names[i].toString() + "\n");
		}
		return text;
	}	
}
