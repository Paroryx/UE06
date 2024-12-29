public class JavalandNumber{

    public static void main(String[] args) {
        printNumber(-12345);
        Out.println();
        printNumber(12345);
        Out.println();
        printNumber(-350);
        Out.println();
        printNumber(0);
        Out.println();
    }

    private static void printNumber(int num) {
        if(num >= 0 && num < 10){ // size is only one digit
            Out.print(digitToText(num));
        }else if(num<0){
            Out.print("Minus");
            printNumber(Math.abs(num));
        }else{
            // num >= 10
            printNumber(num/10);
            Out.print(digitToText(num%10));
        }
    }
    private static String digitToText(int digit){
        switch (Math.abs(digit)) {
            default:
                return null;
            case 0:
                return "Zero";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
    }
}