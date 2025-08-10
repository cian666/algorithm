package cn.cian.combination;

import java.util.ArrayList;
import java.util.List;

public class P17_LetterCombinations {

    ArrayList<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()  == 0)
            return res;
        String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder("");
        backTrack(str,digits,sb,0);
        return res;
    }

    private void backTrack(String[] str, String digits, StringBuilder s,int start) {
        if(s.length() == digits.length()){
            res.add(s.toString());
            return;
        }
        String list = str[digits.charAt(start) - '0'];
        for (int i = 0; i <list.length() ; i++) {
            s.append(list.charAt(i));
            backTrack(str,digits,s,start+1);
            s.deleteCharAt(s.length()-1);
        }
    }
}
