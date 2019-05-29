package p8;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MyRootPane {
	
	private TextField wordCountField;
	private TextArea originalText;
	private TextArea goofyText;
	private MenuBar menuBar;
	private MenuItem load;
	private Menu file;
	private FileChooser fileChooser;
	private TextField chooseWord;
	private Label originalTextLabel;
	private Label goofyTextLabel;
	private Label chooseWordLabel;
	private GridPane pane;
	private VBox vBox;
	private Iterator it;
	private MasterLinkList list;
	private Button goofyButton;
	
	public MyRootPane() {
		this.menuBar = new MenuBar();
		this.load = new MenuItem("Load");
		this.file = new Menu("File");
		this.file.getItems().addAll(load);
		this.menuBar.getMenus().add(file);
		this.pane = new GridPane();
		this.pane.setHgap(1);
		this.pane.setVgap(4);
		this.pane.setPadding(new Insets(4));
		this.pane.setMaxSize(5000, 5000);
		this.wordCountField = new TextField();
		wordCountField.setPromptText("Enter number of words");
		this.goofyText = new TextArea();
		this.goofyText.setMaxSize(300, 500);
		this.goofyButton = new Button("Goofy Version");
		this.originalText = new TextArea();
		this.originalText.setMaxSize(300, 500);
		this.chooseWord = new TextField();
		chooseWord.setPromptText("Choose a word from the lyrics above");
		this.originalTextLabel = new Label("Original Text");
		this.goofyTextLabel = new Label("Goofy Text");
		this.pane.add(originalTextLabel, 1, 1);
		this.pane.add(originalText, 1, 2);
		this.pane.add(chooseWord, 1, 3);
		this.pane.add(wordCountField, 1, 4);
		this.pane.add(goofyButton, 1, 5);
		this.pane.add(goofyTextLabel, 1, 6);
		this.pane.add(goofyText, 1, 7);
		this.vBox = new VBox(menuBar, pane);
		this.fileChooser = new FileChooser();
		this.list = new MasterLinkList();
		this.it = new Iterator(this.list);
		
		
		load.setOnAction(e -> {
			File file = fileChooser.showOpenDialog(new Stage());
			try {
				this.it.importData(file);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
			try {
				this.originalText.setText(this.it.importData(file));
				this.originalText.setWrapText(true);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String s = this.originalText.getText();
			this.it.parseLyrics(s);
			this.list.displayMasterList();
			
		});
		
		goofyButton.setOnAction(e -> {
			String nonsense = this.it.generateNonsense(this.chooseWord.getText(), Integer.parseInt(this.wordCountField.getText()));
			this.getGoofyText().setText(nonsense);
			this.goofyText.setWrapText(true);
			this.it.exportData(nonsense);
			
		});
		
		
	}

	public VBox getvBox() {
		return vBox;
	}

	public void setvBox(VBox vBox) {
		this.vBox = vBox;
	}

	public TextArea getOriginalText() {
		return originalText;
	}

	public void setOriginalText(TextArea originalText) {
		this.originalText = originalText;
	}

	public TextArea getGoofyText() {
		return goofyText;
	}

	public void setGoofyText(TextArea goofyText) {
		this.goofyText = goofyText;
	}

	public MenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(MenuBar menuBar) {
		this.menuBar = menuBar;
	}

	

	public MenuItem getLoad() {
		return load;
	}

	public void setLoad(MenuItem load) {
		this.load = load;
	}

	public Menu getFile() {
		return file;
	}

	public void setFile(Menu file) {
		this.file = file;
	}

	public FileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(FileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	public TextField getChooseWord() {
		return chooseWord;
	}

	public void setChooseWord(TextField chooseWord) {
		this.chooseWord = chooseWord;
	}

	public Label getOriginalTextLabel() {
		return originalTextLabel;
	}

	public void setOriginalTextLabel(Label originalTextLabel) {
		this.originalTextLabel = originalTextLabel;
	}

	public Label getGoofyTextLabel() {
		return goofyTextLabel;
	}

	public void setGoofyTextLabel(Label goofyTextLabel) {
		this.goofyTextLabel = goofyTextLabel;
	}

	public Label getChooseWordLabel() {
		return chooseWordLabel;
	}

	public void setChooseWordLabel(Label chooseWordLabel) {
		this.chooseWordLabel = chooseWordLabel;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public Iterator getIt() {
		return it;
	}

	public void setIt(Iterator it) {
		this.it = it;
	}

	public MasterLinkList getList() {
		return list;
	}

	public void setList(MasterLinkList list) {
		this.list = list;
	}
	

}

