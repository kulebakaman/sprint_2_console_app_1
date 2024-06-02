import java.util.InputMismatchException;
import java.util.Scanner;

class Introduction{
	private int numberOfPeople;
	
	public int startTheConversation(Scanner scan) {
		System.out.println("Здравствуйте!");
		System.out.print("Подскажите, пожалуйста, на сколько человек надо разделить счёт? ");
		
		while(true) {
			try {
				numberOfPeople = scan.nextInt();
				
				if(numberOfPeople < 1) {
					System.out.println("Указано некорректное количество человек.");
					System.out.print("Пожалуйста, укажите корректное число человек, большее одного: ");
				}
				
				if(numberOfPeople == 1) {
					System.out.println("Расчёт не нужен, так как количество указанных человек равно одному.");
					System.out.print("Пожалуйста, укажите корректное количество человек, большее одного: ");
				}
				
				if(numberOfPeople > 1) {
					scan.nextLine();
					return numberOfPeople;
				}
			}catch(InputMismatchException e) {
				System.out.print("ОШИБКА! Введены некорректные данные. Пожалуйста, введите целое число: ");
				scan.nextLine();
			}
		}
	}
}
