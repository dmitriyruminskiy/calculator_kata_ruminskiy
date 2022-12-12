import java.util.HashMap;

class Convertor {
    public String arabToRoman(String n) {
        int number = Integer.parseInt(n);
        int[] romanValueList = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanCharList = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < romanValueList.length; i += 1) {
            while (number >= romanValueList[i]) {
                number -= romanValueList[i];
                res.append(romanCharList[i]);
            }
        }
        return res.toString();
    }

    public String romanToArab(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = map.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = map.get(arr[i]);
            if (arabian < map.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return String.valueOf(result);
    }
}
