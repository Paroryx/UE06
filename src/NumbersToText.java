public class NumbersToText {
    public static void main(String[] args) {
        testNumberToText(832, "EightThreeTwo");
        testNumberToText(-832, "MinusEightThreeTwo");
        testNumberToText(7001, "SevenZeroZeroOne");
        testNumberToText(-1, "MinusOne");
    }
    static void testNumberToText(int number, String expected) {
        Out.println("Testing numberToText (%d):".formatted(number));
        String result = numberToText(number);
        Out.println(" Result: %s".formatted(result));
        if (result.equals(expected)) {
            Out.println(" SUCCESS: Result matches expected result");
        } else {
            Out.println(" ERROR: Result does not match expected result %s".formatted(expected));
        }
        Out.println();
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

    private static String numberToText(int number){
        StringBuilder sb = new StringBuilder();
        boolean isNegative = number<0;

        number = Math.abs(number);
        while(number > 0){
            sb.insert(0, digitToText(number%10));
            number = number/10;
        }
        if(isNegative){
            sb.insert(0, "Minus");
        }
        return sb.toString();
    }
}
