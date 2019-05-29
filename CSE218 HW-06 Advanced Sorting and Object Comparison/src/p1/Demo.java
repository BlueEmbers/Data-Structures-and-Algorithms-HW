package p1;

public class Demo 
{

	public static void main(String[] args) {
		
		CoinArray array = new CoinArray(100);
		
		for(int i = 0; i< array.getArray().length; i++) {
			Coin coin = new Coin((int)(Math.random()*6));
			array.insert(coin);
		}
		array.display();
		System.out.println();
		array.quickSort();
		array.display();
	}
}