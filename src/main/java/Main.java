import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NotFoundArithmeticalOperationException {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String expression = console.nextLine();
        System.out.println("Результат:");
        System.out.println(calc(expression));
        console.close();
    }

    public static String calc(String expression) throws NotFoundArithmeticalOperationException {
        String[] arrElements = divisionIntoOperands(expression);
        String operator = arrElements[0];
        String a = arrElements[1];
        String b = arrElements[2];

        Calculator calculator;
        if (isArabic(a, b)) {
            calculator = new CalculatorArab(a, b);
        } else {
            calculator = new CalculatorRim(a, b);
        }

        return switch (operator) {
            case ("*") -> calculator.multiply();
            case ("+") -> calculator.add();
            case ("-") -> calculator.subtraction();
            case ("/") -> calculator.division();
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

    private static String[] divisionIntoOperands(String input) throws NotFoundArithmeticalOperationException {
        String expressionWithoutWhiteSpace = input.replaceAll("\\s", "");

        String[] pair = expressionWithoutWhiteSpace.split("[+*/-]");
        if (pair.length == 1)
            throw new NotFoundArithmeticalOperationException("Строка не является математической операцией, либо введен неверный оператор!");
        if (pair.length != 2)
            throw new NotFoundArithmeticalOperationException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор(+,-,/,*)!");
        String operator = expressionWithoutWhiteSpace.substring(pair[0].length(),
                expressionWithoutWhiteSpace.length() - pair[1].length());
        String elementA = pair[0];
        String elementB = pair[1];

        String[] number = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean elementAFound = false;
        boolean elementBFound = false;
        for (String s : number) {
            if (s.equals(elementA)) {
                elementAFound = true;
            }
            if (s.equals(elementB)) {
                elementBFound = true;
            }
        }
        if (!elementAFound)
            throw new NotFoundArithmeticalOperationException("Введенное значение не удовлетворяет условию задачи!");
        if (!elementBFound)
            throw new NotFoundArithmeticalOperationException("Введенное значение не удовлетворяет условию задачи!");

        return new String[]{operator, elementA, elementB};
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isArabic(String a, String b) {
        if (isNumeric(a) && isNumeric(b)) {
            return true;
        } else if (!isNumeric(a) && !isNumeric(b)) {
            return false;
        } else {
            throw new ArithmeticException("Одновременно разные системы счисления!");
        }
    }
}
