class Solution {
    public String reverseWords(String s) {

        // "\\s+" => Split String ONE or MORE Spaces
        String[] strArr = s.strip().split("\\s+");
        int len = strArr.length - 1;

        for(int i=0; i<len; i++){
            String temp = strArr[i];
            strArr[i] = strArr[len];
            strArr[len] = temp;
            len--;
        }

        return String.join(" ", strArr);
        
    }
}