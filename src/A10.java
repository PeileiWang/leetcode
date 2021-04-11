import java.util.regex.Pattern;

/**
 * @author: wangpeilei
 * @date: 2021/04/11 13:51
 **/
public class A10 {

    private static class Solution {
        public boolean isMatch(String s, String p) {
            return Pattern.matches(p, s);
        }
    }
}
