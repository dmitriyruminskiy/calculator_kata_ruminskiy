class CalculatorRim implements Calculator{
    String a;
    String b;

    Convertor convertor = new Convertor();

    public CalculatorRim(String a, String b) {
        this.a = convertor.romanToArab(a);
        this.b = convertor.romanToArab(b);
    }

    @Override
    public String add() {
        int c = Integer.parseInt(a) + Integer.parseInt(b);
        return convertor.arabToRoman(String.valueOf(c));
    }

    @Override
    public String multiply() {
        int c = Integer.parseInt(a) * Integer.parseInt(b);
        return convertor.arabToRoman(String.valueOf(c));
    }

    @Override
    public String subtraction() {
        int c = Integer.parseInt(a) - Integer.parseInt(b);
        if (c < 1) {
            throw new ArithmeticException("Римское число не может быть отрицательным, либо равнятся 0!");
        }
        return convertor.arabToRoman(String.valueOf(c));
    }

    @Override
    public String division() {
        int c = Math.round(Integer.parseInt(a) / Integer.parseInt(b));
        if (c < 1) {
            throw new ArithmeticException("Римское число не может быть отрицательным, либо равнятся 0!");
        }
        return convertor.arabToRoman(String.valueOf(c));
    }
}
