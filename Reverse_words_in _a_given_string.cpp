// Given a String S, reverse the string without reversing its individual words. Words are separated by dots.

// Example 1:

// Input:
// S = i.like.this.program.very.much
// Output: much.very.program.this.like.i
// Explanation: After reversing the whole
// string(not individual words), the input
// string becomes
// much.very.program.this.like.i
// Example 2:

// Input:
// S = pqr.mno
// Output: mno.pqr
// Explanation: After reversing the whole
// string , the input string becomes
// mno.pqr

// Your Task:
// You dont need to read input or print anything. Complete the function reverseWords() which takes string S as input parameter and returns a string containing the words in reversed order. Each word in the returning string should also be separated by '.' 


// Expected Time Complexity: O(|S|)
// Expected Auxiliary Space: O(|S|)


// Constraints:
// 1 <= |S| <= 105




// code :

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution
{
    public:
    //Function to reverse words in a given string.
    string reverseWords(string S) 
    { 
        // code here 
        reverse(S.begin(),S.end());
        S= S + ".";
        
        int j = 0;
        for(int i=0; i<S.length();i++){
            if(S[i]=='.'){
                reverse(S.begin()+j,S.begin()+i);
                j=i+1;
            }
        }
        
        S.pop_back();
        return S ;
    } 
};

//{ Driver Code Starts.
int main() 
{
    int t;
    cin >> t;
    while (t--) 
    {
        string s;
        cin >> s;
        Solution obj;
        cout<<obj.reverseWords(s)<<endl;
    }
}
// } Driver Code Ends
