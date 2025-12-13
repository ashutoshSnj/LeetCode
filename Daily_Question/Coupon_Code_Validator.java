package Daily_Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coupon_Code_Validator {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<Integer> validIndices = new ArrayList<>();

        Set<String> allowedBusinessLines = new HashSet<>(
            Arrays.asList("electronics", "grocery", "pharmacy", "restaurant")
        );

        for (int i = 0; i < code.length; i++) {
            if (isActive[i] &&
                allowedBusinessLines.contains(businessLine[i]) &&
                isValidCouponCode(code[i])) {
                validIndices.add(i);
            }
        }

        validIndices.sort((index1, index2) -> {
            int businessLineComparison =
                businessLine[index1].compareTo(businessLine[index2]);
            if (businessLineComparison != 0) {
                return businessLineComparison;
            }
            return code[index1].compareTo(code[index2]);
        });

        List<String> sortedCouponCodes = new ArrayList<>();
        for (int index : validIndices) {
            sortedCouponCodes.add(code[index]);
        }

        return sortedCouponCodes;
    }

    private boolean isValidCouponCode(String couponCode) {
        if (couponCode.isEmpty()) {
            return false;
        }

        for (char character : couponCode.toCharArray()) {
            if (!Character.isLetterOrDigit(character) && character != '_') {
                return false;
            }
        }

        return true;
    }
}
