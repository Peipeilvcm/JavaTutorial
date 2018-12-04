package oj.swordtooffer;

public class STO27_RevSentence {
    public String ReverseSentence(String str){
        if(str == null || str == ""){
            return str;
        }
        String[] strs = str.split(" ");
        if(strs.length == 0){
            return str;
        }
        StringBuilder sb = new StringBuilder();

        for(int i = str.length() - 1; i > 0; ++i){
            sb.append(strs[i]);
        }
        sb.append(strs[0]);
        return sb.toString();
    }
}
