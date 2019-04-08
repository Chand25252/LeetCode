package solutions;

import java.util.ArrayList;
import java.util.List;

/*
    给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
*/

/**
 * @author Chand
 * @date 2019-04-08 15:43:24
 */
public class Q093_Restore_IP_Addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return results;
        }
        List<String> result = new ArrayList<>();
        partition(results, result, s);
        return results;
    }

    private void partition(List<String> results, List<String> result, String s) {
        if (s.isEmpty()) {
            return;
        }
        if (result.size() == 3) {
            if (s.charAt(0) == '0' && s.length() > 1) {
                return;
            }
            if (Integer.valueOf(s) <= 255) {
                String item = result.get(0) + "." + result.get(1) + "." + result.get(2) + "." + s;
                results.add(item);
            }
            return;
        }
        if (s.charAt(0) == '0') {
            List<String> temp = new ArrayList<>(result);
            temp.add("0");
            partition(results, temp, s.substring(1));
            return;
        }
        if (s.length() >= 3) {
            List<String> temp = new ArrayList<>(result);
            String threeNum = s.substring(0, 3);
            if (Integer.valueOf(threeNum) <= 255) {
                temp.add(threeNum);
                partition(results, temp, s.substring(3));
            }
        }
        if (s.length() >= 2) {
            List<String> temp = new ArrayList<>(result);
            String twoNum = s.substring(0, 2);
            temp.add(twoNum);
            partition(results, temp, s.substring(2));
        }
        if (s.length() >= 1) {
            List<String> temp = new ArrayList<>(result);
            String oneNum = s.substring(0, 1);
            temp.add(oneNum);
            partition(results, temp, s.substring(1));
        }
    }
}
