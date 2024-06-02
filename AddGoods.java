import java.util.HashMap;
import java.util.Scanner;

class AddGoods {
	private String goodName;
	private String goodPrice;
	private double sumOfGoods;
	private HashMap<String, String> goodsMap = new HashMap<>();
	
	public void addGoodsMethod(Scanner scan) {
		while(true) {
			System.out.print("Пожалуйста введите название товара: ");
			if(scan.hasNextLine()) {
				goodName = scan.nextLine();
			}
		
			System.out.print("Пожалуйста введите цену товара \'" + goodName + "\': ");
			while(true) {
				if(scan.hasNextLine()) {
					goodPrice = scan.nextLine();
				}
				
				if(!goodPrice.matches("^[-+]?[0-9]*[.,]?[0-9]+(?:[eE][-+]?[0-9]+)?$")) {
					System.out.print("Вы ввели не число. Попробуйте  ввести корректную цену снова: ");
				}else if(Double.parseDouble(goodPrice) < 0) {
					System.out.print("Цена товара не может быть отрицательной. Попробуйте ввести её снова: ");
				}else if(Double.parseDouble(goodPrice) >= 0) {
					break;
				}
			}
			
			goodsMap.put(goodName, goodPrice);
			sumOfGoods += Double.parseDouble(goodPrice);
			
			System.out.println("Товар успешно добавлен.");
			System.out.print("Вы хотите добавить ещё один товар (наберите \'Да\' для добавления товара "
					+ "и \'Завершить\' чтобы завершить процесс): ");
			while(true) {
				String answer = scan.nextLine();
				if("да".equalsIgnoreCase(answer)) {
					break;
				}else if("Завершить".equalsIgnoreCase(answer)) {
					return;
				}else if(!answer.equalsIgnoreCase("Да") && !answer.equalsIgnoreCase("Завершить")) {
					System.out.print("Некорреткный ввод. Пожалуйста, введите \'Да\' или \'Завершить\': ");
				}
			}
		}
	}

	public void showGoodsMethod(int number) {
		System.out.println("Добавленные товары:");
		for (String goodName: goodsMap.keySet()) {
		    String key = goodName.toString();
		    String value = goodsMap.get(goodName).toString();
		    System.out.println(key + " " + value);
		}
		
		System.out.println();
		
		double sumOfGoodsPart = sumOfGoods / number;
		int sumOfGoodsIntPart = (int) sumOfGoods;
		
		if(sumOfGoodsIntPart == 0) {
			System.out.println(String.format("Каждый человек должен заплатить %.2f рублей.", sumOfGoodsPart));
		}else if(sumOfGoodsIntPart == 1) {
			System.out.println(String.format("Каждый человек должен заплатить %.2f рубль.", sumOfGoodsPart));
		}else if(sumOfGoodsIntPart >= 2 && sumOfGoodsIntPart <= 4) {
			System.out.println(String.format("Каждый человек должен заплатить %.2f рубля.", sumOfGoodsPart));
		}else if(sumOfGoodsIntPart >= 5 && sumOfGoodsIntPart <= 20) {
			System.out.println(String.format("Каждый человек должен заплатить %.2f рублей.", sumOfGoodsPart));
		}else if(sumOfGoodsIntPart == 21) {
			System.out.println(String.format("Каждый человек должен заплатить %.2f рубль.", sumOfGoodsPart));
		}else if(sumOfGoodsIntPart >= 22 && sumOfGoodsIntPart <= 24) {
			System.out.println(String.format("Каждый человек должен заплатить %.2f рубля.", sumOfGoodsPart));
		}else if(sumOfGoodsIntPart >= 25 && sumOfGoodsIntPart <= 30) {
			System.out.println(String.format("Каждый человек должен заплатить %.2f рублей.", sumOfGoodsPart));
		}
	}
}
