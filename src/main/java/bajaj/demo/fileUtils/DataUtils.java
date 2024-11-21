package bajaj.demo.fileUtils;

import java.util.ArrayList;
import java.util.List;

public class DataUtils 
{
	public static List<String> extractNumbers(List<String> data) {
        List<String> numbers = new ArrayList<>();
        for (String item : data) {
            if (item.matches("\\d+")) {
                numbers.add(item);
            }
        }
        return numbers;
    }

    public static List<String> extractAlphabets(List<String> data) {
        List<String> alphabets = new ArrayList<>();
        for (String item : data) {
            if (item.matches("[a-zA-Z]")) {
                alphabets.add(item);
            }
        }
        return alphabets;
    }

    public static List<String> getHighestLowercase(List<String> data) {
        String highest = null;
        for (String item : data) {
            if (item.matches("[a-z]") && (highest == null || item.compareTo(highest) > 0)) {
                highest = item;
            }
        }
        return highest != null ? List.of(highest) : new ArrayList<>();
    }

    public static boolean containsPrime(List<String> numbers) {
        for (String num : numbers) {
            int value = Integer.parseInt(num);
            if (isPrime(value)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
}
}
