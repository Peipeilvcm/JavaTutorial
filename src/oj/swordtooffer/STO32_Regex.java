package oj.swordtooffer;

public class STO32_Regex {
    public boolean match(char[] str, char[] pattern){
        if(str == null && pattern == null){
            return false;
        }
        return helper(str,0,pattern,0);
    }
    public boolean helper(char[] str, int sIndex, char[] pattern, int pIndex){
        //str到尾，pattern到尾，匹配成功
        if (sIndex == str.length && pIndex == pattern.length) {
            return true;
        }
        //str未到尾，pattern到尾，匹配失败
        if (sIndex != str.length && pIndex == pattern.length) {
            return false;
        }
        //str到尾，pattern未到尾(不一定匹配失败，因为a*可以匹配0个字符)
        if (sIndex == str.length && pIndex != pattern.length) {
            //只有pattern剩下的部分类似a*b*c*的形式，才匹配成功
            if (pIndex + 1 < pattern.length && pattern[pIndex + 1] == '*') {
                return helper(str, sIndex, pattern, pIndex + 2);
            }
            return false;
        }

        //str未到尾，pattern未到尾
        if (pIndex + 1 < pattern.length && pattern[pIndex + 1] == '*') {
            if (pattern[pIndex] == str[sIndex] || (pattern[pIndex] == '.' && sIndex != str.length)) {
                return helper(str, sIndex, pattern, pIndex + 2)//*匹配0个，跳过
                        || helper(str, sIndex + 1, pattern, pIndex + 2)//*匹配1个，跳过
                        || helper(str, sIndex + 1, pattern, pIndex);//*匹配1个，再匹配str中的下一个
            } else {
                //直接跳过*（*匹配到0个）
                return helper(str, sIndex, pattern, pIndex + 2);
            }
        }

        if (pattern[pIndex] == str[sIndex] || (pattern[pIndex] == '.' && sIndex != str.length)) {
            return helper(str, sIndex + 1, pattern, pIndex + 1);
        }

        return false;
    }
}
