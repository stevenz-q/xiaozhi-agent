package com.yqz.xiaozhi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoyq
 * @since 2025/11/29  13:25
 */
public class Test {
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        dfs(digits.length(), 0, digits, new String());
        return res;
    }

    public void dfs(int len, int depth, String s, String sub) {
        if (sub.length() == len) {
            res.add(sub);
            return;
        }
        char c =(char)('a' + (s.charAt(depth) - '2') * 3);
        dfs(len, depth + 1, s, sub + c);
        dfs(len, depth + 1, s, sub+(char)(c+1));
        dfs(len, depth + 1, s, sub+(char)(c+2));
    }

    public static void main(String[] args) {
        ////String sub ="abc";
        ////char c= 'd';
        ////String s = sub + c;
        ////System.out.println(s);
        Test test = new Test();
        List<String> strings = test.letterCombinations("7");
        System.out.println(strings);
        //System.out.println((int)'a');
        //System.out.println((int)'d');
        //System.out.println((char)100);
    }

}
