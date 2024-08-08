class Solution {
public:
    bool isPalindrome(string s) {

        string str ;

        for(int i=0; i<s.length(); i++){
            if((s[i]>='A' && s[i]<='Z')){
                str += s[i] - 'A' + 'a' ;
            }
            else if (s[i]>='a' && s[i]<='z'){
                str += s[i] ;
            }
            else if(s[i]>='0' && s[i] <= '9' ){
                str += s[i] ;
            }
        }

        if(str.empty() || (str.length() == 1)){
            return true ;
        } 

        string str1 = str ;
        reverse(str.begin(), str.end());

        if(str != str1){
            return false ;
        }
        
        return true ;
    
        
    }
};