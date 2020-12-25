import java.util.Scanner;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {
		Start startProgramm = new Start();
		startProgramm.startMenu();
		
	}
}
class Start{
	ArrayList<String> users = new ArrayList<String>();
	void startMenu() {
		int start_menu;
		System.out.printf("1-����\n2-�����������\n");
		Scanner sc = new Scanner(System.in);
		System.out.printf("�������� ����� ����: ");
		start_menu = sc.nextInt();
		switch(start_menu){
			case 1:
				boolean entr = enter();
				if(entr) {
					ChooseMenu cMenu = new ChooseMenu();
					cMenu.chooseMenu();
				}else {
					System.out.println("������������������?");
					startMenu();
				}
				break;
			case 2:
				//registration();
				ChooseMenu cMenu = new ChooseMenu(registration());
				cMenu.chooseMenu();
				break;
		}
	}
	boolean enter() {
		String login, password;
		Scanner sc = new Scanner(System.in);
		System.out.printf("������� ����: \n");
		login = sc.nextLine();
		System.out.printf("������� ������: \n");
		password = sc.nextLine();
		if(this.users.contains(login)){
			if(this.users.contains(password)){
				return true;
	        }else {System.out.printf("�� ����� ������������ ������!\n");return false;}
        }else {System.out.printf("�� ����� ������������ �����!\n");return false;}
    }
	Person registration() {
		String login, password, name, secondname, patronumic, city, street, building, phone;
		int entrance, floor, flat;
		Scanner sc = new Scanner(System.in);
		System.out.printf("���������� ����: \n");
		login = sc.nextLine();
		this.users.add(login);
		System.out.printf("���������� ������: \n");
		password = sc.nextLine();
		this.users.add(password);
		System.out.printf("������� ���: \n");
		name = sc.nextLine();
		System.out.printf("������� �������: \n");
		secondname = sc.nextLine();
		System.out.printf("������� ��������: \n");
		patronumic = sc.nextLine();
		System.out.printf("������� ����� ��������: \n");
		phone = sc.nextLine();
		System.out.printf("������� �������� ������: \n");
		city = sc.nextLine();
		System.out.printf("������� �������� �����: \n");
		street = sc.nextLine();
		System.out.printf("������� ����� ����: \n");
		building = sc.nextLine();
		System.out.printf("������� ����� ��������: \n");
		entrance = sc.nextInt();
		System.out.printf("������� ����: \n");
		floor = sc.nextInt();
		System.out.printf("������� ����� ��������: \n");
		flat = sc.nextInt();
		Adress newUserAdress = new Adress(city, street, building, entrance, floor, flat);
		Person newUser = new Person(login, password, name, secondname, patronumic, phone, newUserAdress);
		newUser.displayInfo();
		//System.out.printf("\n");
		return newUser;
	}
}
class ChooseMenu{
	Person user;
	ChooseMenu(){};
	ChooseMenu(Person user){
		this.user = user;
	};
	void chooseMenu() {
		int c_menu;
		System.out.printf("1-������ �������\n2-�������� ����\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("�������� ����� ����: ");
		c_menu = sc.nextInt();
		switch(c_menu){
			case 1:
				UserMenu uMenu = new UserMenu(this.user);
				uMenu.showMenu();
				break;
			case 2:
				MainMenu uMainMenu = new MainMenu(this.user);
				uMainMenu.showMenu();
				break;
		}
	}
}
class MainMenu{
	Person user;
	Store store;
	Product product;
	MainMenu(){
		this.store = new Store();
		this.product = new Product();
	}
	MainMenu(Person user){
		this.user = user;
		this.store = new Store();
		this.product = new Product();
	}
	void showMenu() {
		int main_menu;
		System.out.printf("1-�����\n2-��������\n3-���������\n4-�����\n5-�����\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("�������� ����� ����: ");
		main_menu = sc.nextInt();
		switch(main_menu){
			case 1:
				viewStocks();
				showMenu();
				break;
			case 2:
				viewShops();
				showMenu();
				break;
			case 3:
				viewRestaurants();
				showMenu();
				break;
			case 4:
				viewFood();
				showMenu();
				break;
			case 5:
				exit();
				break;
		}
	}
	void viewStocks() {
		ArrayList<String> stocksList = new ArrayList<String>();
		stocksList.add("������ �� ������!");
        for(String stock : stocksList){
            System.out.println(stock);
        }
        int stocks_menu;
		System.out.printf("1-������� ��������\n2-������� �����\n3-�����\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("�������� ����� ����: ");
		stocks_menu = sc.nextInt();
		switch(stocks_menu) {
			case 1:
				viewRestaurants();
				break;
			case 2:
				viewFood();
				break;
			case 3:
				showMenu();
				break;
		}
	}
	void viewShops() {
		ArrayList<String> shopsList = new ArrayList<String>();
		shopsList.add("���������");
        for(String shop : shopsList){
            System.out.println(shop);
        }
	}
	void viewRestaurants() {
        System.out.println(store.name);
        int restaurants_menu;
		System.out.printf("1-������� �����\n2-�����\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("�������� ����� ����: ");
		restaurants_menu = sc.nextInt();
		switch(restaurants_menu) {
			case 1:
				viewFood();
				break;
			case 2:
				showMenu();
				break;
		}
	}
	void viewFood() {
        System.out.println(product.name);
        int food_menu;
		System.out.printf("1-��������\n2-�����\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("�������� ����� ����: ");
		food_menu = sc.nextInt();
		switch(food_menu) {
			case 1:
				Product burger = new Product();
				burger.Buy(user, product.price, store.name);
				break;
			case 2:
				showMenu();
				break;
		}
	}
	void exit() {
		ChooseMenu cMenu = new ChooseMenu(this.user);
		cMenu.chooseMenu();
	}
}
class UserMenu{
	Person user;
	UserMenu(){}
	UserMenu(Person user){
		this.user = user;
	}
	void showMenu() {
		int user_menu;
		System.out.printf("1-������ ������\n2-������ ��������\n3-��� ������\n4-��� ������\n5-�����\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("�������� ����� ����: ");
		user_menu = sc.nextInt();
		switch(user_menu){
			case 1:
				editUser();
				break;
			case 2:
				editAdress();
				break;
			case 3:
				viewOrders(user);
				break;
			case 4:
				viewDiscounts();
				break;
			case 5:
				exit(this.user);
				break;
		}
	}
	void editUser() {
		user.editInfo();
	}
	void editAdress() {
		user.adress.editInfo(user);
	}
	void viewOrders(Person user) {
		System.out.printf("��� �����: \n");
		System.out.printf("����� ��������: \n%s\n%s\n%s\n%d\n%d\n%d",
				user.orders.adress.city, 
				user.orders.adress.street,
				user.orders.adress.building,
				user.orders.adress.entrance,
				user.orders.adress.floor,
				user.orders.adress.flat);
		System.out.printf("�������: %s\n�����: %s\n����: %d\n", user.orders.store, user.orders.productName, user.orders.price);
	}
	void viewDiscounts() {}
	void exit(Person user) {
		ChooseMenu cMenu = new ChooseMenu(user);
		cMenu.chooseMenu();
	}
}
class Stocks{
	
}
class Store{
	String name;
	Store(){
		this.name = "���������";
	}
}
class Product{
	String name;
	boolean stock;
	int price;
	Store store;
	Product(){
		this.name = "������";
		this.price = 250;
		this.stock = true;
	}
	void Buy(Person user, int price, String name) {
		user.orders = new Orders(name, user.adress, price, this.name);
		//user.orders.price = price;
		//user.orders.store = name;
		//user.orders.productName = this.name;
	}
}
class Orders{
	String store;
	Adress adress;
	String productName;
	int price;
	Orders(){}
	Orders(String store, Adress adress, int price, String product){
		this.store = store;
		this.adress = adress;
		this.price = price;
		this.productName = product;
	}
	
}
class Person{
	String login, password;
	String name, secondname, patronumic;
	String phone;
	Adress adress;
	Orders orders;
	Person(){
		name = "Name";
		secondname= "Secondname";
		patronumic = "Patronumic";
		adress = new Adress();
	}
	Person(String login, String password, String name, String secondname, String patronumic, String phone, Adress adress){
		this.login = login;
		this.password = password;
		this.name = name;
		this.secondname = secondname;
		this.patronumic = patronumic;
		this.phone = phone;
		this.adress = adress;
	}
	void displayInfo() {
		System.out.printf("���: %s\n�������: %s\n��������: %s\n�������: %s",name, secondname, patronumic, phone);
		System.out.printf("\n");
		this.adress.displayInfo();
	}
	void editInfo() {
		int ei_menu;
		System.out.printf("1-�������� ���\n2-�������� �������\n3-�������� ��������\n4-�������� �������\n5-�����\n");
		Scanner sc = new Scanner(System.in);
		ei_menu = sc.nextInt();
		switch(ei_menu) {
			case 1:
				editName();
				editInfo();
				break;
			case 2:
				editSecondName();
				editInfo();
				break;
			case 3:
				editPatronumic();
				editInfo();
				break;
			case 4:
				editPhone();
				editInfo();
				break;
			case 5:
				exit();
				break;
		}
	}
	void editName() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("������� ����� ���\n");
		this.name = sc.nextLine();
	}
	void editSecondName() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("������� ����� �������\n");
		this.secondname = sc.nextLine();
	}
	void editPatronumic() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("������� ����� ��������\n");
		this.patronumic = sc.nextLine();
	}
	void editPhone() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("������� ����� �������\n");
		this.phone = sc.nextLine();
	}
	void exit() {
		UserMenu uMenu = new UserMenu(getPerson());
		uMenu.showMenu();
	}
	Person getPerson() {
		Person user = new Person(this.login, this.password,this.name, this.secondname, this.patronumic, this.phone, this.adress);
		return user;
	}

}
class Adress{
	String city, street, building;
	int entrance, floor, flat;
	Adress(){
		city = "city";
		street = "street";
		building = "building";
	}
	Adress(String city, String street, String building, int entrance, int floor, int flat){
		this.city = city;
		this.street = street;
		this.building = building;
		this.entrance = entrance;
		this.floor = floor;
		this.flat = flat;
	}
	void displayInfo() {
		System.out.printf("�����: %s\n�����: %s\n���: %s\n��������: %s\n����: %s\n��������: %s",city, street, building,entrance, floor, flat);
	}
	void editInfo(Person user) {
		Person localUser = user;
		int ei_menu;
		System.out.printf("1-�������� �����\n2-�������� �����\n3-�������� ����� ����\n4-�������� ��������\n5-�������� ����\n6-�������� ��������\n7-�����\n");
		Scanner sc = new Scanner(System.in);
		ei_menu = sc.nextInt();
		switch(ei_menu) {
			case 1:
				editCity() ;
				editInfo(localUser);
				break;
			case 2:
				editStreet();
				editInfo(localUser);
				break;
			case 3:
				editBuilding();
				editInfo(localUser);
				break;
			case 4:
				editEntrance();
				editInfo(localUser);
				break;
			case 5:
				editFloor();
				editInfo(localUser);
				break;
			case 6:
				editFlat();
				editInfo(localUser);
				break;
			case 7:
				exit(localUser);
				break;
		}
	}
	void editCity() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("������� ����� �����\n");
		this.city = sc.nextLine();
	}
	void editStreet() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("������� ����� �����\n");
		this.street = sc.nextLine();
	}
	void editBuilding() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("������� ���\n");
		this.building = sc.nextLine();
	}
	void editEntrance() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("������� ����� ��������\n");
		this.entrance = sc.nextInt();
	}
	void editFloor() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("������� ����� ����\n");
		this.floor = sc.nextInt();
	}
	void editFlat() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("������� ����� ��������\n");
		this.flat = sc.nextInt();
	}
	void exit(Person user) {
		UserMenu uMenu = new UserMenu(user);
		uMenu.showMenu();
	}
	
}