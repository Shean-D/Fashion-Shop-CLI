public static void bestSellingCatSortedByAmount(){
    clearConsole();
    System.out.println("	 _____                  _                _     ____                                                             _   \r\n    / ____|                | |              | |   |  _ \\                /\\                                         | |  \r\n   | (___     ___    _ __  | |_    ___    __| |   | |_) |  _   _       /  \\     _ __ ___     ___    _   _   _ __   | |_ \r\n    \\___ \\   / _ \\  | \'__| | __|  / _ \\  / _` |   |  _ <  | | | |     / /\\ \\   | \'_ ` _ \\   / _ \\  | | | | | \'_ \\  | __|\r\n    ____) | | (_) | | |    | |_  |  __/ | (_| |   | |_) | | |_| |    / ____ \\  | | | | | | | (_) | | |_| | | | | | | |_ \r\n   |_____/   \\___/  |_|     \\__|  \\___|  \\__,_|   |____/   \\__, |   /_/    \\_\\ |_| |_| |_|  \\___/   \\__,_| |_| |_|  \\__|\r\n                                                            __/ |                                                       \r\n                                                           |___/                                                        ");
    System.out.println("___________________________________________________________________________________________________");

    String [] tempTSize = {"XS","S","M","L","XL","XXL"};
    int [] tempQyt = new int[6];
    double [] totalAmount = new double[6];
    int count =0;

    for(int i=0; i<tSize.length; i++){
        switch (tSize[i]) {
            case "xs":
                tempQyt[0] += qyt[i];
                totalAmount[0] += amount[i];
                break;
            
            case "s":
                tempQyt[1] += qyt[i];
                totalAmount[1] += amount[i];
                break;
            
            case "m":
                tempQyt[2] += qyt[i];
                totalAmount[2] += amount[i];
                break;
            
            case "l":
                tempQyt[3] += qyt[i];
                totalAmount[3] += amount[i];
                break;

            case "xl":
                tempQyt[4] += qyt[i];
                totalAmount[4] += amount[i];
                break;
            
            case "xxl":
                tempQyt[5] += qyt[i];
                totalAmount[5] += amount[i];
                break;
        }
    }

    for(int i=0; i<totalAmount.length; i++){
        for(int j=0; j<totalAmount.length-1; j++){
            if(totalAmount[j]<totalAmount[j+1]){

                double tempAmount = totalAmount[j];
                totalAmount[j] = totalAmount[j+1];
                totalAmount[j+1] = tempAmount;

                int totalQyt = tempQyt[j];
                tempQyt[j] = tempQyt[j+1];
                tempQyt[j+1] = totalQyt;

                String size = tempTSize[j];
                tempTSize[j] = tempTSize[j+1];
                tempTSize[j+1] = size;
            }
        }
    }

    System.out.println("\n\n\t\t+------+------+----------------+");
    System.out.printf("\t\t"+"|%-6s|%-6s|%-16s|"," Size","  QYT","   Total Amount");
    System.out.print("\n\t\t+------+------+----------------+");

    for(int i=0; i<totalAmount.length; i++){
        System.out.printf("\n\t\t"+"|%-6s|%-6d|%-16.2f|",tempTSize[i],tempQyt[i],totalAmount[i]);
        System.out.println();
    }
    System.out.println("\n\t\t+------+------+----------------+");

    System.out.print("\n\tTo access the Main Menu, please enter 0 : ");
    int option = input.nextInt();

    if(option==0){
        System.out.println("\n\n\t\t\tRedirecting to the Home Page... ");
        sleep(2000);
        homePage();
    }else {
        bestSellingCatSortedByAmount();
    }
}