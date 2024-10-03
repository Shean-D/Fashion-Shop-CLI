import java.util.*;

public class Fashion_shop {

    public static Scanner input = new Scanner(System.in);

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

    public static void main(String args[]) {
        homePage();
    }

    public static void homePage() {
        String str = "\r\n" +
                "                    " +
                "                    " +
                "         /$$$$$$$$  " +
                "               /$$  " +
                "     /$$            " +
                "                /$$$" +
                "$$$  /$$            " +
                "              \r\n" +
                "                    " +
                "                    " +
                "        | $$_____/  " +
                "              | $$  " +
                "    |__/            " +
                "               /$$__" +
                "  $$| $$            " +
                "              \r\n" +
                "                    " +
                "                    " +
                "        | $$    /$$$" +
                "$$$   /$$$$$$$| $$$$" +
                "$$$  /$$  /$$$$$$  /" +
                "$$$$$$$       | $$  " +
                "\\__/| $$$$$$$   /$$" +
                "$$$$   /$$$$$$ \r\n" +
                "                    " +
                "                    " +
                "        | $$$$$|____" +
                "  $$ /$$_____/| $$__" +
                "  $$| $$ /$$__  $$| " +
                "$$__  $$      |  $$$" +
                "$$$ | $$__  $$ /$$__" +
                "  $$ /$$__  $$\r\n" +
                "                    " +
                "                    " +
                "        | $$__/ /$$$" +
                "$$$$|  $$$$$$ | $$  " +
                "\\ $$| $$| $$  \\ $$" +
                "| $$  \\ $$       \\" +
                "____  $$| $$  \\ $$|" +
                " $$  \\ $$| $$  \\ $" +
                "$\r\n" +
                "                    " +
                "                    " +
                "        | $$   /$$__" +
                "  $$ \\____  $$| $$ " +
                " | $$| $$| $$  | $$|" +
                " $$  | $$       /$$ " +
                " \\ $$| $$  | $$| $$" +
                "  | $$| $$  | $$\r\n" +
                "                    " +
                "                    " +
                "        | $$  |  $$$" +
                "$$$$ /$$$$$$$/| $$  " +
                "| $$| $$|  $$$$$$/| " +
                "$$  | $$      |  $$$" +
                "$$$/| $$  | $$|  $$$" +
                "$$$/| $$$$$$$/\r\n" +
                "                    " +
                "                    " +
                "        |__/   \\___" +
                "____/|_______/ |__/ " +
                " |__/|__/ \\______/ " +
                "|__/  |__/       \\_" +
                "_____/ |__/  |__/ \\" +
                "______/ | $$____/ \r" +
                "\n" +
                "                    " +
                "                    " +
                "                    " +
                "                    " +
                "                    " +
                "                    " +
                "                    " +
                "    | $$      \r\n" +
                "                    " +
                "                    " +
                "                    " +
                "                    " +
                "                    " +
                "                    " +
                "                    " +
                "    | $$      \r\n" +
                "                    " +
                "                    " +
                "                    " +
                "                    " +
                "                    " +
                "                    " +
                "                    " +
                "    |__/      \r\n";

        System.out.println(str);
        System.out.println(
                "\t\t\t\t\t\t_____________________________________________________________________________________________________________");
        System.out.print("\n\n\n\t\t\t\t\t\t\t[1] Place Order\t\t\t\t\t\t\t\t[2] Search Customer");
        System.out.print("\n\n\n\t\t\t\t\t\t\t[3] Search Order\t\t\t\t\t\t\t[4] View Reports");
        System.out.println("\n\n\n\t\t\t\t\t\t\t[5] Set Order Status\t\t\t\t\t\t\t[6] Delete Order");

        // System.out.print("\n\n\n\n\t\t\t\t\t\tInput Option : ");
        String srt = "Input Option";
        System.out.printf("\n\n" + "%60s:", srt);
        int Option = input.nextInt();

        switch (Option) {
            case 1:
                placeOrder();
                break;
            case 2:
                break;
            default:
                homePage();
                break;
        }
    }

    public static void placeOrder() {
        clearConsole();
        
        String str = "\r\n" +
        "      _____  _      " +
        "             ____   " +
        "       _           " +
        "\r\n" +
        "     |  __ \\| |    " +
        "             / __ \\" +
        "        | |         " +
        " \r\n" +
        "     | |__) | | __ _" +
        "  ___ ___  | |  | |_" +
        " __ __| | ___ _ __ " +
        "\r\n" +
        "     |  ___/| |/ _` " +
        "|/ __/ _ \\ | |  | |" +
        " \'__/ _` |/ _ \\ \'" +
        "__|\r\n" +
        "     | |    | | (_| " +
        "| (_|  __/ | |__| | " +
        "| | (_| |  __/ |   " +
        "\r\n" +
        "     |_|    |_|\\__," +
        "_|\\___\\___|  \\___" +
        "_/|_|  \\__,_|\\___|" +
        "_|   \r\n" +
        "                    " +
        "                    " +
        "                   " +
        "\r\n" +
        "                    " +
        "                    " +
        "                   " +
        "\r\n";

        System.out.println(str+"   ______________________________________________________");
        
        //String orderId = generateOrderId();
        System.out.print("\nEnter Order ID : ");

        System.out.print("\nEnter Customer Phone Number : ");
        String phoneNumber = input.next();

        //need to add validation method here to check 4n number 

        System.out.print("\nEnter T-Shirt Size (XS/S/M/L/XL/XXL) : ");
        String Tsize = input.next();

        System.out.print("\nEnter QTY : ");
        int qty = input.nextInt();

        System.out.print("Amount : ");

        System.out.print("\n\nDo you want to place this order ? (Y/N) : ");
        String placeOrder = input.next().toLowerCase();

        if (placeOrder.equals("y")) {
            System.out.println("\n\n\tOrder Placed....!");
            //need to add data to the arrays last index
        }
        System.out.print("\nDo you want to place another order ? (Y/N) : ");
        String anotherOrder = input.next().toLowerCase();

        if (anotherOrder.equals("y")) {
            placeOrder();
        }else if(anotherOrder.equals("n")){
            homePage();
        }

    }
}
