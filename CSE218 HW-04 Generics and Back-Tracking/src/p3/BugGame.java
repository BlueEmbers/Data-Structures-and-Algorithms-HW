package p3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BugGame extends Application
{
	private GridPane grid;
	private Button[][] gameTable;
	private Image ladyBug;
	private ImageView image;
	private LinkedList<Point> stack;
	private Point current;
	private Button undo;
	private Point lastP;
	private ListIterator<Point> it;
	
	public BugGame()
	{
		try
		{
			ladyBug = new Image(new FileInputStream("C:\\Users\\Kurama\\Documents\\download.jpg"));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		undo = new Button("Undo");
		undo.setPrefHeight(40);
		undo.setPrefWidth(80);
		undo.setOnAction(ActionEvent -> {
			undo();
		});
		it = null;
		image = new ImageView(ladyBug);
		image.setFitHeight(20);
		image.setFitWidth(20);
		grid = new GridPane();
		gameTable = new Button[10][10];
		stack = new LinkedList<Point>();
		stack.add(new Point((int)(Math.random() * 10),(int)(Math.random() *10)));
		
		for(int i = 0; i < gameTable.length; i++)
		{
			for(int j = 0; j < gameTable.length; j++)
			{
				Button b = new Button();
				b.setPrefHeight(40);
				b.setPrefWidth(40);
				b.setId(String.valueOf((i*10) + j));
				b.setLayoutX(i);
				b.setLayoutY(j);
				b.setOnAction(ActionEvent -> {
				if(search(b)) 
				{
					gameTable[stack.getLast().getX()][stack.getLast().getY()].setGraphic(new ImageView());
					stack.addLast(current);
					it = stack.listIterator();
					while(it.hasNext())
					{
						System.out.println(it.next());
					}
					System.out.println("yes");
					
					b.setGraphic(image);
				}
				});
				gameTable[i][j] = b;
				grid.add(b, j, i);
			}
			
		}grid.add(undo,  11,  0);
		
	}
	
	public ImageView getImage()
	{
		return image;
	}
	
	public void setImage(ImageView image)
	{
		this.image = image;
	}
	
	public LinkedList<Point> getStack()
	{
		return stack;
	}
	public void setStack(LinkedList<Point> stack)
	{
		this.stack = stack;
	}
	public boolean search(Button button)
	{
		for(int a = 0; a < gameTable.length; a++)
		{
			for(int b = 0; b < gameTable.length; b++)
			{
				if(gameTable[a][b].getId() == button.getId()) 
				{
					current = new Point(a,b);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isAdjacent(Button button)
	{
		Point lastPoint = stack.getLast();
		for(int a = 0; a < gameTable.length; a++)
		{
			for(int b = 0; b < gameTable.length; b++)
			{
				if(gameTable[a][b].getId() == button.getId())
				{
					int xDiff = Math.abs(lastPoint.getX() - a);
					int yDiff = Math.abs(lastPoint.getY() - b);
					if(xDiff <= 1 && yDiff <=1)
					{
						current = new Point(a,b);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void undo()
	{
		if(!stack.isEmpty())
		{
			gameTable[stack.getLast().getX()][stack.getLast().getY()].setGraphic(new ImageView());
			stack.removeLast();
			if(!stack.isEmpty())
			{
				gameTable[stack.getLast().getX()][stack.getLast().getY()].setGraphic(image);
				current = stack.getLast();
			}
		}
	}
	
	public void setImage()
	{
		gameTable[1][2].setGraphic(new ImageView(ladyBug));
	}
	
	public Button[][] getGameTable()
	{
		return gameTable;
	}
	
	public void setGameTable(Button[][] gameTable)
	{
		this.gameTable = gameTable;
	}
	
	public Image getLadyBug()
	{
		return ladyBug;
	}
	
	public void setLadyBug(Image ladyBug)
	{
		this.ladyBug = ladyBug;
	}
	
	@Override 
	public void start(Stage arg0) throws Exception
	{
		
	}
	
	public GridPane getGrid()
	{
		return grid;
	}
	public void setGrid(GridPane grid)
	{
		this.grid = grid;
	}

}

