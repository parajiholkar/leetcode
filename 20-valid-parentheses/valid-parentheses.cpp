#include<stack>

class Solution {
public:
    bool isValid(string s) {

        if(s.length() == 1){
            return false ;
        }

        stack<char> st;
        st.push('a');

        for(int i=0; i<s.length() ; i++){

            if(s[i]=='(' || s[i]=='{' || s[i]=='['){
                st.push(s[i]);
            }else{

                if(st.empty()){
                        return false ;
                    }
                
                if((s[i] == ')' && st.top() == '(') || (s[i] == ']' && st.top() == '[') || (s[i] == '}' && st.top() == '{')){
                    
                    st.pop();
                    
                }else {
                    return false ;
                }
            }

        }

        if(st.top() == 'a'){
            st.pop();
        }


        if(st.empty()){
            return true ;
        }

        return false ;
        
        
    }
};