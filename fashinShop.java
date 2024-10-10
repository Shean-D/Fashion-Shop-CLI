import java.util.*;

class fashinShop {
	public static Scanner input = new Scanner(System.in);

	public static String[] orderId = new String[0];
	public static String[] customerPhoneNumber = new String[0];
	public static String[] tSize = new String[0];
	public static int[] qyt = new int[0];
	public static int[] orderStatus = new int[0];
	public static double[] amount = new double[0];

	public static final int statusProcessing = 0;
	public static final int statusDelivering = 1;
	public static final int statusDelivered = 2;

	public static int orderIdNumber = 00000;

	public static void main(String args[]) {
		homePage();
	}

	/// ---------------->Clear Console Method<------------------------------
	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c",
						"cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();
			// Handle any exceptions.
		}
	}
	/// -------------------------><---------------------------------------

	/// ---------------->Home Page Method<--------------------------------
	public static void homePage() {
		clearConsole();

		System.out.println(
				"\n            $$$$$$$$\\                     $$\\       $$\\                  $$$$$$\\  $$\\                           \r\n            $$  _____|                    $$ |      \\__|                $$  __$$\\ $$ |                          \r\n            $$ |       $$$$$$\\   $$$$$$$\\ $$$$$$$\\  $$\\ $$$$$$$\\        $$ /  \\__|$$$$$$$\\   $$$$$$\\   $$$$$$\\  \r\n            $$$$$\\     \\____$$\\ $$  _____|$$  __$$\\ $$ |$$  __$$\\       \\$$$$$$\\  $$  __$$\\ $$  __$$\\ $$  __$$\\ \r\n            $$  __|    $$$$$$$ |\\$$$$$$\\  $$ |  $$ |$$ |$$ |  $$ |       \\____$$\\ $$ |  $$ |$$ /  $$ |$$ /  $$ |\r\n            $$ |      $$  __$$ | \\____$$\\ $$ |  $$ |$$ |$$ |  $$ |      $$\\   $$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |\r\n            $$ |      \\$$$$$$$ |$$$$$$$  |$$ |  $$ |$$ |$$ |  $$ |      \\$$$$$$  |$$ |  $$ |\\$$$$$$  |$$$$$$$  |\r\n            \\__|       \\_______|\\_______/ \\__|  \\__|\\__|\\__|  \\__|       \\______/ \\__|  \\__| \\______/ $$  ____/ \r\n                                                                                                      $$ |      \r\n                                                                                                      $$ |      \r\n                                                                                                      \\__|      ");
		System.out.println(
				"\t________________________________________________________________________________________________________");
		System.out.printf("\n\n" + "%40s %50s", "[1] Place Order", "[2] Search Customer");
		System.out.printf("\n\n" + "%41s %45s", "[3] Search Order", "[4] View Report");
		System.out.printf("\n\n" + "%45s %42s", "[5] Set Order Status", "[6] Delete Order");

		System.out.printf("\n\n\n" + "%40s", "Input Option : ");
		int option = input.nextInt();

		switch (option) {
			case 1:
				placeOrder();
				break;
			case 2:
				searchCustomer();
				break;
			case 3:
				searchOrder();
				break;
			case 4:
				viewReport();
				break;
			// case 5 : setOrderStatus(); break;
			case 6:
				deleteOrder();
				break;
			default:
				clearConsole();
				homePage();
		}
	}
	/// -------------------------><---------------------------------------

	/// ---------------->Place Order Method<------------------------------
	public static void placeOrder() {

		clearConsole();
		System.out.println(
				"\r\n    _____    _                            ____               _               \r\n   |  __ \\  | |                          / __ \\             | |              \r\n   | |__) | | |   __ _    ___    ___    | |  | |  _ __    __| |   ___   _ __ \r\n   |  ___/  | |  / _` |  / __|  / _ \\   | |  | | | \'__|  / _` |  / _ \\ | \'__|\r\n   | |      | | | (_| | | (__  |  __/   | |__| | | |    | (_| | |  __/ | |   \r\n   |_|      |_|  \\__,_|  \\___|  \\___|    \\____/  |_|     \\__,_|  \\___| |_|   \r\n                                                                             \r\n                                                                             \r\n");
		System.out.println("   ____________________________________________________________________________");

		String Id = generatedOrderId();

		System.out.println("\n\n\n    Enter Order ID : " + Id);
		validatePhoneNumber();
		String phoneNumber = validatePhoneNumber();

		System.out.print("\n    Enter T-Shirt Size (XS/S/M/L/XL/XXL) : ");
		String size = input.next().toLowerCase();

		System.out.print("\n    Enter QYT : ");
		int q = input.nextInt();

		double tamount = priceChart(size, q);
		System.out.println("\n    Amount : " + tamount);

		System.out.print("\n    Do you want to place this order ? (Y/N) : ");
		String placeOrderOption = input.next().toLowerCase();

		if (placeOrderOption.equals("y")) {
			extendArrays();
			orderId[orderId.length - 1] = Id;
			tSize[tSize.length - 1] = size;
			qyt[qyt.length - 1] = q;
			amount[amount.length - 1] = tamount;
			orderStatus[orderStatus.length - 1] = 0;
			customerPhoneNumber[customerPhoneNumber.length - 1] = phoneNumber;
			System.out.println("\n\n\t\t\tCustomer Added Successfully..!");

		} else if (placeOrderOption.equals("n")) {
			decrementedOrderId();
		} else {
			System.out.println("\n\n\t\t\tInvalid Input.. Please Enter Order Again...!");
			sleep(2000);
			decrementedOrderId();
			placeOrder();
		}

		System.out.print("\n    Do you want to place another order ? (Y/N) : ");
		String anotherOrder = input.next().toLowerCase();

		if (anotherOrder.equals("y")) {
			placeOrder();
		} else if (anotherOrder.equals("n")) {
			homePage();
		} else {
			System.out.println("\n\n\t\tInvalid Input..! redirecting to the Home Page");
			sleep(3000);
			homePage();
		}
	}
	/// -------------------------><---------------------------------------

	/// ---------------->Sleep Method<------------------------------------
	public static void sleep(int sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			System.out.println("Thread was interrupted.");
		}
	}
	/// -------------------------><---------------------------------------

	/// ---------------->Extend Arrays Method<------------------------
	public static void extendArrays() {
		String[] tempOrderId = new String[orderId.length + 1];
		String[] tempCustomerPhoneNumber = new String[customerPhoneNumber.length + 1];
		String[] tempTSize = new String[tSize.length + 1];
		int[] tempQyt = new int[qyt.length + 1];
		int[] tempOrderStatus = new int[orderStatus.length + 1];
		double[] tempAmount = new double[amount.length + 1];

		for (int i = 0; i < orderId.length; i++) {
			tempOrderId[i] = orderId[i];
			tempTSize[i] = tSize[i];
			tempQyt[i] = qyt[i];
			tempAmount[i] = amount[i];
			tempOrderStatus[i] = orderStatus[i];
			tempCustomerPhoneNumber[i] = customerPhoneNumber[i];
		}
		orderId = tempOrderId;
		tSize = tempTSize;
		qyt = tempQyt;
		amount = tempAmount;
		orderStatus = tempOrderStatus;
		customerPhoneNumber = tempCustomerPhoneNumber;

	}
	/// -------------------------><---------------------------------------

	/// ---------------->Generate Order ID Method<------------------------
	public static String generatedOrderId() {

		orderIdNumber++;
		String orderNumber = String.format("ORD#%05d", orderIdNumber);
		return orderNumber;
	}

	public static void decrementedOrderId() {
		orderIdNumber--;
	}

	/// -------------------------><---------------------------------------

	/// ---------------->Validate Phone Number<---------------------------
	public static String validatePhoneNumber() {
		String number;
		L2: while (true) {
			System.out.print("\n    Enter Customer Phone Number : ");
			number = input.next();

			if (number.length() == 10 || number.charAt(0) == '0') {
				break;
			} else {
				System.out.println("\n\n\t\t\tInvalid Phone Number... Try Again...");

				System.out.print("\n    Do you want to enter phone number again (Y/N) : ");
				String option = input.next().toLowerCase();

				switch (option) {
					case "y":
						continue L2;
					case "n":
						System.out.println("Redirecting to the Home Page..");
						sleep(3000);
						homePage();
						break;
					default:
						System.out.println("Invalid Input... Redirecting to the Home Page..");
						sleep(3000);
						homePage();
						break;
				}

			}

		}
		return number;
	}
	/// -------------------------><---------------------------------------

	/// ---------------->Price chart & Ordder Amount cal<----------------
	public static double priceChart(String size, int q) {
		switch (size) {
			case "xs":
				return 600 * q;
			case "s":
				return 800 * q;
			case "m":
				return 900 * q;
			case "l":
				return 1000 * q;
			case "xl":
				return 1100 * q;
			case "xxl":
				return 1200 * q;
		}
		return 0;
	}
	/// -------------------------><---------------------------------------

	/// ---------------->Search Customer<---------------------------------
	public static void searchCustomer() {
		clearConsole();
		System.out.println(
				"\r\n     _____                                _          _____                 _                                     \r\n    / ____|                              | |        / ____|               | |                                    \r\n   | (___     ___    __ _   _ __    ___  | |__     | |       _   _   ___  | |_    ___    _ __ ___     ___   _ __ \r\n    \\___ \\   / _ \\  / _` | | \'__|  / __| | \'_ \\    | |      | | | | / __| | __|  / _ \\  | \'_ ` _ \\   / _ \\ | \'__|\r\n    ____) | |  __/ | (_| | | |    | (__  | | | |   | |____  | |_| | \\__ \\ | |_  | (_) | | | | | | | |  __/ | |   \r\n   |_____/   \\___|  \\__,_| |_|     \\___| |_| |_|    \\_____|  \\__,_| |___/  \\__|  \\___/  |_| |_| |_|  \\___| |_|   \r\n                                                                                                                 \r\n                                                                                                                 \r\n");
		System.out.println(
				"   ______________________________________________________________________________________________________________");

		System.out.print("\n\n    Enter Customer Phone Number : ");
		String contact = input.next();

		int[] index = searchCustomerByP_number(contact);

		if (index.length == 0) {
			System.out.println("\n\n\t\t\tCustomer Not Found..!");
		} else {
			showCustomerDetails(index);
		}
		System.out.print("\n\nDo you want to search another customer ? (Y/N) : ");
		String option = input.next().toLowerCase();

		if (option.equals("y")) {
			searchCustomer();
		} else if (option.equals("n")) {
			System.out.println("\n\n\t\t\tRedirecting To Home Page... ");
			sleep(3000);
			homePage();
		} else {
			System.out.println("\n\n\t\t\tInvalid Input...! Redirecting To Home Page... ");
			sleep(3000);
			homePage();
		}

	}

	public static int[] searchCustomerByP_number(String contact) {
		int count = 0;

		for (int i = 0; i < customerPhoneNumber.length; i++) {
			if (customerPhoneNumber[i].equals(contact)) {
				count++;
			}
		}

		int[] searchResultArray = new int[count];
		if (count == 0)
			return searchResultArray;
		int index = 0;

		for (int i = 0; i < customerPhoneNumber.length; i++) {
			if (customerPhoneNumber[i].equals(contact)) {
				searchResultArray[index] = i;
				index++;
			}
		}
		return searchResultArray;

	}
	/// -------------------------><---------------------------------------

	/// ---------------->Show Customer Details<---------------------------
	public static void showCustomerDetails(int[] index) {
		double total = 0;
		int[] tempQytArray = new int[index.length];
		String[] tempSizeArray = new String[index.length];
		double[] tempAmountArray = new double[index.length];
		int totalCount = 0;

		for (int i = 0; i < index.length; i++) {
			int tempQyt = qyt[index[i]];
			String tempSize = tSize[index[i]];
			double tempAmount = amount[index[i]];

			boolean found = false;
			for (int j = 0; j < totalCount; j++) {
				if (tempSizeArray[j].equals(tempSize)) {
					tempQytArray[j] += tempQyt;
					tempAmountArray[j] += tempAmount;
					found = true;
					break;
				}
			}

			if (!found) {
				tempSizeArray[totalCount] = tempSize;
				tempQytArray[totalCount] = tempQyt;
				tempAmountArray[totalCount] = tempAmount;
				totalCount++;
			}
		}

		for (int i = 0; i < index.length; i++) {
			for (int j = 0; j < index.length - 1; j++) {
				if (tempAmountArray[j] < tempAmountArray[j + 1]) {

					double tempA = tempAmountArray[j];
					tempAmountArray[j] = tempAmountArray[j + 1];
					tempAmountArray[j + 1] = tempA;

					String tempS = tempSizeArray[j];
					tempSizeArray[j] = tempSizeArray[j + 1];
					tempSizeArray[j + 1] = tempS;

					int tempQ = tempQytArray[j];
					tempQytArray[j] = tempQytArray[j + 1];
					tempQytArray[j + 1] = tempQ;
				}
			}
		}

		// System.out.println(Arrays.toString(tempAmountArray));
		// System.out.println(Arrays.toString(tempSizeArray));
		// System.out.println(Arrays.toString(tempQytArray));

		System.out.print("\n\n\t\t\t\t+--------+-------+------------+");
		System.out.print("\n\t\t\t\t|  Size  |  Qyt  |   Amount   |");

		for (int i = 0; i < totalCount; i++) {
			System.out.print("\n\t\t\t\t+--------+-------+------------+");
			// System.out.printf("\n\t\t\t\t|"+"%-8s|%-7d|%,12.2f|",tSize[index[i]],qyt[index[i]],amount[index[i]]);
			System.out.printf("\n\t\t\t\t|" + "%-8s|%-7d|%,12.2f|", tempSizeArray[i], tempQytArray[i],
					tempAmountArray[i]);
			total += tempAmountArray[i];
		}

		System.out.print("\n\t\t\t\t+--------+-------+------------+");
		System.out.printf("\n\t\t\t\t|" + "%-16s|%,12.2f|", "  Total Amount", total);
		System.out.print("\n\t\t\t\t+--------+-------+------------+");

	}
	/// -------------------------><---------------------------------------

	/// ---------------->Search Order Details<---------------------------
	public static void searchOrder() {
		clearConsole();
		System.out.println(
				"     _____                                _          ____               _               \r\n    / ____|                              | |        / __ \\             | |              \r\n   | (___     ___    __ _   _ __    ___  | |__     | |  | |  _ __    __| |   ___   _ __ \r\n    \\___ \\   / _ \\  / _` | | \'__|  / __| | \'_ \\    | |  | | | \'__|  / _` |  / _ \\ | \'__|\r\n    ____) | |  __/ | (_| | | |    | (__  | | | |   | |__| | | |    | (_| | |  __/ | |   \r\n   |_____/   \\___|  \\__,_| |_|     \\___| |_| |_|    \\____/  |_|     \\__,_|  \\___| |_|   \r\n                                                                                        \r\n                                                                                        ");
		System.out.println("   ______________________________________________________________________________________");

		System.out.print("\n    Enter order ID : ");
		String id = input.next();

		int index = searchOrderById(id);

		if (index == -1) {
			System.out.println("\n\n\t\t\tInvalid Order ID..");
		} else if (index != -1) {
			int i = index;
			String status = getOrderStatus(i);
			System.out.printf("\n\n    " + "%-13s: %-13s", "Phone Number", customerPhoneNumber[i]);
			System.out.printf("\n    " + "%-13s: %-13s", "Size", tSize[i]);
			System.out.printf("\n    " + "%-13s: %-13d", "QYT", qyt[i]);
			System.out.printf("\n    " + "%-13s: %-,13.2f", "Amount", amount[i]);
			System.out.printf("\n    " + "%-13s: %-13s", "Status", status);
		}
		System.out.print("\n\n    Do you want to search another order ? (Y/N) : ");
		String option = input.next().toLowerCase();

		if (option.equals("y")) {
			searchOrder();
		} else if (option.equals("n")) {
			System.out.println("\n\n\t\t\tRedirecting to the Home Page...");
			sleep(3000);
			homePage();
		} else {
			System.out.println("\n\n\t\t\tInvalid Input..! Redirecting to the Home Page...");
			sleep(3000);
			homePage();
		}

	}
	/// -------------------------><---------------------------------------

	/// ---------------->Search Order By ID<-------------------------------
	public static int searchOrderById(String id) {
		for (int i = 0; i < orderId.length; i++) {
			if (orderId[i].equals(id)) {
				return i;
			}
		}
		return -1;
	}
	/// -------------------------><---------------------------------------

	/// ---------------->Get Order Status<-------------------------------
	public static String getOrderStatus(int index) {
		String status = "Processing";

		if (orderStatus[index] == 1) {
			status = "Delivering";
			return status;
		} else if (orderStatus[index] == 2) {
			status = "Deliverd";
			return status;
		}

		return status;
	}
	/// -------------------------><---------------------------------------

	/// ---------------->Delete Order------<-------------------------------
	public static void deleteOrder() {
		clearConsole();
		System.out.println(
				"    _____           _          _               ____               _               \r\n   |  __ \\         | |        | |             / __ \\             | |              \r\n   | |  | |   ___  | |   ___  | |_    ___    | |  | |  _ __    __| |   ___   _ __ \r\n   | |  | |  / _ \\ | |  / _ \\ | __|  / _ \\   | |  | | | \'__|  / _` |  / _ \\ | \'__|\r\n   | |__| | |  __/ | | |  __/ | |_  |  __/   | |__| | | |    | (_| | |  __/ | |   \r\n   |_____/   \\___| |_|  \\___|  \\__|  \\___|    \\____/  |_|     \\__,_|  \\___| |_|   \r\n                                                                                  \r\n                                                                                  ");
		System.out.println("   __________________________________________________________________________________");

		System.out.print("\n\n    Enter order ID : ");
		String id = input.next();

		int index = searchOrderById(id);

		if (index == -1) {
			System.out.println("\n\n\t\t\tInvalid Order ID..");
		} else if (index != -1) {
			// int i = index;
			String status = getOrderStatus(index);
			System.out.printf("\n\n    " + "%-13s: %-13s", "Phone Number", customerPhoneNumber[index]);
			System.out.printf("\n    " + "%-13s: %-13s", "Size", tSize[index]);
			System.out.printf("\n    " + "%-13s: %-13d", "QYT", qyt[index]);
			System.out.printf("\n    " + "%-13s: %-,13.2f", "Amount", amount[index]);
			System.out.printf("\n    " + "%-13s: %-13s", "Status", status);

			System.out.print("\n\n    Do you want to delete this order ? (Y/N) : ");
			String option = input.next().toLowerCase();

			if (option.equals("y")) {
				removeOrder(index);
				sleep(2000);
				System.out.println("\n\n\t\t\tOrder Deleted Successfully..!\n");

			} else if (option.equals("n")) {
				System.out.println("\n\n\t\t\tRedirecting to Home Page..!");
				sleep(3000);
				homePage();

			} else {
				System.out.println("\n\n\t\t\tInvalid Input...! Redirecting to Home Page..!");
				sleep(3000);
				homePage();
			}
		}

		System.out.print("Do you want to delete another order ? (Y/N) : ");
		String deleteAgain = input.next().toLowerCase();

		if (deleteAgain.equals("y")) {
			deleteOrder();
		} else if (deleteAgain.equals("n")) {
			System.out.println("\n\n\t\t\tRedirecting to Home Page..!");
			sleep(3000);
			homePage();
		} else {
			System.out.println("\n\n\t\t\tInvalid Input...! Redirecting to Home Page..!");
			sleep(3000);
			homePage();
		}

	}
	/// -------------------------><--------------------------------------------

	/// ---------------->Remove Order<-----------------------------------------
	public static void removeOrder(int index) {
		String[] tempOrderIdArray = new String[orderId.length - 1];
		String[] tempCustomerPhoneNumberArray = new String[customerPhoneNumber.length - 1];
		String[] tempTSizeArray = new String[tSize.length - 1];
		int[] tempQytArray = new int[qyt.length - 1];
		int[] tempOrderStatusArray = new int[orderStatus.length - 1];
		double[] tempAmountArray = new double[amount.length - 1];

		for (int i = index; i < orderId.length - 1; i++) {
			tempOrderIdArray[i] = orderId[i + 1];
			tempTSizeArray[i] = tSize[i + 1];
			tempQytArray[i] = qyt[i + 1];
			tempAmountArray[i] = amount[i + 1];
			tempOrderStatusArray[i] = orderStatus[i + 1];
			tempCustomerPhoneNumberArray[i] = customerPhoneNumber[i + 1];
		}
		for (int i = 0; i < index; i++) {
			tempOrderIdArray[i] = orderId[i];
			tempTSizeArray[i] = tSize[i];
			tempQytArray[i] = qyt[i];
			tempAmountArray[i] = amount[i];
			tempOrderStatusArray[i] = orderStatus[i];
			tempCustomerPhoneNumberArray[i] = customerPhoneNumber[i];
		}
		orderId = tempOrderIdArray;
		tSize = tempTSizeArray;
		qyt = tempQytArray;
		amount = tempAmountArray;
		orderStatus = tempOrderStatusArray;
		customerPhoneNumber = tempCustomerPhoneNumberArray;
	}
	/// -------------------------><---------------------------------------

	/// --------------------->View Reports Page<--------------------------------

	public static void viewReport() {
		clearConsole();
		System.out.print(
				"    _____                                  _         \r\n   |  __ \\                                | |        \r\n   | |__) |   ___   _ __     ___    _ __  | |_   ___ \r\n   |  _  /   / _ \\ | \'_ \\   / _ \\  | \'__| | __| / __|\r\n   | | \\ \\  |  __/ | |_) | | (_) | | |    | |_  \\__ \\\r\n   |_|  \\_\\  \\___| | .__/   \\___/  |_|     \\__| |___/\r\n                   | |                               \r\n                   |_|                               ");
		System.out.println("\n________________________________________________________");

		System.out.println("\n\n\t\t[1] Customer Reports\n\n\t\t[2] Item Reports\n\n\t\t[3] Orders Report");
		System.out.print("\n\n\tEnter option : ");
		int option = input.nextInt();

		switch (option) {
			case 1:
				customerReports();
				break;
			// case 2 : itemReports();
			// break;
			// case 3 : ordersReports();
			// break;
			default:
				System.out.println("\n\n\t\t\tInvalid Input...!");

				System.out.print("\n\n\t\tDo you want to enter option again ? (y/n) : ");
				String ynOption = input.next().toLowerCase();

				if (ynOption.equals("y")) {
					viewReport();
				} else if (ynOption.equals("n")) {
					System.out.println("\n\n\t\tRedirecting to the Home Page...");
					sleep(2000);
					homePage();
				} else {
					System.out.println("\n\n\t\tInvalid Input..! Redirecting to the Home Page...");
					sleep(2000);
					homePage();

				}
				break;
		}

	}
	/// -------------------------><---------------------------------------

	/// --------------------->Customer Reports Page<----------------------
	public static void customerReports() {
		clearConsole();

		System.out.println(
				"     _____                 _                                         _____                                  _         \r\n    / ____|               | |                                       |  __ \\                                | |        \r\n   | |       _   _   ___  | |_    ___    _ __ ___     ___   _ __    | |__) |   ___   _ __     ___    _ __  | |_   ___ \r\n   | |      | | | | / __| | __|  / _ \\  | \'_ ` _ \\   / _ \\ | \'__|   |  _  /   / _ \\ | \'_ \\   / _ \\  | \'__| | __| / __|\r\n   | |____  | |_| | \\__ \\ | |_  | (_) | | | | | | | |  __/ | |      | | \\ \\  |  __/ | |_) | | (_) | | |    | |_  \\__ \\\r\n    \\_____|  \\__,_| |___/  \\__|  \\___/  |_| |_| |_|  \\___| |_|      |_|  \\_\\  \\___| | .__/   \\___/  |_|     \\__| |___/\r\n                                                                                    | |                               \r\n                                                                                    |_|                               ");
		System.out.println(
				"_______________________________________________________________________________________________________________________");
		System.out.println("\n\n\n\t\t[1] Best in Customers\n\n\t\t[2] View Customers\n\n\t\t[3] All Customer Report");

		System.out.print("\n\n\tEnter option : ");
		int option = input.nextInt();

		switch (option) {
			case 1: bestInCustomers();
				break;
			//case 2: viewCustomers();
			//	break;
			//case 3: allCustomerReport();
			//	break;

			default:
				System.out.println("\n\n\t\t\tInvalid Input...!");

				System.out.print("\n\n\t\tDo you want to enter option again ? (y/n) : ");
				String ynOption = input.next().toLowerCase();

				if (ynOption.equals("y")) {
					customerReports();

				} else if (ynOption.equals("n")) {
					System.out.println("\n\n\t\tRedirecting to the Home Page...");
					sleep(2000);
					homePage();

				} else {
					System.out.println("\n\n\t\tInvalid Input..! Redirecting to the Home Page...");
					sleep(2000);
					homePage();
				}
				break;
		}
	}
	/// -------------------------><---------------------------------------

	/// --------------------->Best In Customers<--------------------------
	public static void bestInCustomers(){
		clearConsole();
		System.out.println("	____                 _       _____              _____                 _                                           \r\n   |  _ \\               | |     |_   _|            / ____|               | |                                          \r\n   | |_) |   ___   ___  | |_      | |    _ __     | |       _   _   ___  | |_    ___    _ __ ___     ___   _ __   ___ \r\n   |  _ <   / _ \\ / __| | __|     | |   | \'_ \\    | |      | | | | / __| | __|  / _ \\  | \'_ ` _ \\   / _ \\ | \'__| / __|\r\n   | |_) | |  __/ \\__ \\ | |_     _| |_  | | | |   | |____  | |_| | \\__ \\ | |_  | (_) | | | | | | | |  __/ | |    \\__ \\\r\n   |____/   \\___| |___/  \\__|   |_____| |_| |_|    \\_____|  \\__,_| |___/  \\__|  \\___/  |_| |_| |_|  \\___| |_|    |___/\r\n                                                                                                                      \r\n                                                                                                                      ");
		System.out.println("___________________________________________________________________________________________________________________________");
		
		String [] CusIdArray = new String[customerPhoneNumber.length];
		int [] totalQytArray = new int[customerPhoneNumber.length];
		double [] totalAmountArray = new double[customerPhoneNumber.length];
		int count = 0;

		for(int i=0; i<customerPhoneNumber.length; i++){
			String customer = customerPhoneNumber[i];
			int totalQyt = 0;
			double totalAmount = 0;

			boolean found = false;
			for(int j=0; j<count; j++){
				if(CusIdArray[j].equals(customer)){
					found = true;
					break;
				}
			}

			if(!found){
				for(int k=0; k<customerPhoneNumber.length; k++){
					if(customerPhoneNumber[k].equals(customer)){
						totalQyt += qyt[k];
						totalAmount += amount[k];

					}
				}

				CusIdArray[count] = customer;
				totalQytArray[count] = totalQyt;
				totalAmountArray[count] = totalAmount;
				count++;
			}
		}

		for(int i=0; i<count; i++){
			for(int j=0; j<count-1; j++){
				if(totalAmountArray[j]< totalAmountArray[j+1]){
					
					double tempAmount = totalAmountArray[j];
					totalAmountArray[j] = totalAmountArray[j+1];
					totalAmountArray[j+1] = tempAmount;

					int tempQyt = totalQytArray[j];
					totalQytArray[j] = totalQytArray[j+1];
					totalQytArray[j+1] = tempQyt;

					String tempCusID = CusIdArray[j];
					CusIdArray[j] = CusIdArray[j+1];
					CusIdArray[j+1] = tempCusID;
				}
			}
		}

		System.out.print("\n\n\t\t\t\t+-----------------+-------+--------------+");
		System.out.print("\n\t\t\t\t| Customer Number |  Qyt  | Total Amount |");

		for (int i = 0; i <count; i++) {
			System.out.print("\n\t\t\t\t+-----------------+-------+--------------+");
			System.out.printf("\n\t\t\t\t|" + "%-17s|%-7d|%,14.2f|", CusIdArray[i], totalQytArray[i], totalAmountArray[i]);
		}

		System.out.print("\n\t\t\t\t+-----------------+-------+--------------+");

		System.out.print("\n\n\tTo access the Main Menu, please enter 0 : ");
		int option = input.nextInt();

		switch (option) {
			case 0:
				System.out.println("\n\n\t\t\tRedirecting to the Home Page...");
				sleep(2000);
				homePage();
				break;
		
			default: bestInCustomers();
				break;
		}
	}

}
