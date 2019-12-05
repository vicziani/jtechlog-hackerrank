package change;

import java.util.*;

public class Change {

    public Map<Integer, Integer> change(int amount, List<Integer> denominations) {
        Collections.sort(denominations);
        Collections.reverse(denominations);
        int denomPosition = 0;
        int rest = amount;
        Map<Integer, Integer> result = new HashMap<>();
        while (denomPosition < denominations.size() && rest > 0) {
            int actualDenomination = denominations.get(denomPosition);
            if (rest >= actualDenomination) {
                rest = rest - actualDenomination;
                if (result.get(actualDenomination) == null) {
                    result.put(actualDenomination, 1);
                }
                else {
                    result.put(actualDenomination, result.get(actualDenomination) + 1);
                }
            }
            else {
                denomPosition ++;
            }
        }
        if (rest != 0) {
            throw new IllegalArgumentException("Nem bonthato, eredmeny:" + rest);
        }
        return result;
    }

    public Map<Integer, Integer> changeRec(int amount, List<Integer> denominations) {
        denominations = new ArrayList<>(denominations);
        Collections.sort(denominations);
        Collections.reverse(denominations);
        Map<Integer, Integer> result = new HashMap<>();
        changeSimple(amount, denominations, result);
        return result;
    }

    private void changeSimple(int amount, List<Integer> denominations, Map<Integer, Integer> result) {
        if (amount == 0) {
            return;
        }
        if (denominations.isEmpty()) {
            throw new IllegalArgumentException("Nem bonthato, eredmeny:" + amount);
        }
        else {
            int checkedDenomination = denominations.get(0);
            if (checkedDenomination <= amount) {
                result.put(checkedDenomination, amount / checkedDenomination);
            }
            denominations.remove(0);
            changeSimple(amount % checkedDenomination, denominations, result);
        }
    }


}
