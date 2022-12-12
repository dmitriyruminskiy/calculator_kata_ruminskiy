class CalculatorArab implements Calculator{
    String a;
    String b;

    public CalculatorArab(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String add() {
        int c = Integer.parseInt(a) + Integer.parseInt(b);
        return String.valueOf(c);
    }

    @Override
    public String multiply() {
        int c = Integer.parseInt(a) * Integer.parseInt(b);
        return String.valueOf(c);
    }

    @Override
    public String subtraction() {
        int c = Integer.parseInt(a) - Integer.parseInt(b);
        return String.valueOf(c);
    }

    @Override
    public String division() {
        int c = Math.round(Integer.parseInt(a) / Integer.parseInt(b));
        return String.valueOf(c);
    }
}
