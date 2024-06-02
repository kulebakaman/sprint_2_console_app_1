import java.util.Scanner;

class BillCalculator{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Introduction intro = new Introduction();
		int numberOfPeople = intro.startTheConversation(scanner);
		
		AddGoods addGoods = new AddGoods();
		addGoods.addGoodsMethod(scanner);
		addGoods.showGoodsMethod(numberOfPeople);
	}
}
