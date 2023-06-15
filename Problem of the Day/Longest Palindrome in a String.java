string longestPalin (string s) {
    // code here
    
    int n = s.length(); // Get the length of the input string
    int start = 0, maxlen = 1; // Initialize variables to track the start index and maximum length of the palindrome
    
    for(int i = 1; i < n; i++){ // Iterate through the string
        int l = i - 1, h = i; // Initialize low and high pointers for even-length palindromes
        
        while(l >= 0 && h < n && s[l] == s[h]){ // Expand the palindrome around the center for even-length palindromes
            if(maxlen < h - l + 1){ // Update start and maxlen if a longer palindrome is found
                start = l;
                maxlen = h - l + 1;
            }
            h++;
            l--;
        }
        
        l = i - 1, h = i + 1; // Reset low and high pointers for odd-length palindromes
        
        while(l >= 0 && h < n && s[l] == s[h]){ // Expand the palindrome around the center for odd-length palindromes
            if(maxlen < h - l + 1){ // Update start and maxlen if a longer palindrome is found
                start = l;
                maxlen = h - l + 1;
            }
            h++;
            l--;
        }
    }
    // cout<<start<<" "<<maxlen<<endl; // Uncomment this line to print the start index and maxlen
    
    return s.substr(start, maxlen); // Return the longest palindrome substring
}

class Solution{
static String longestPalin(String S){
    // code here
    int si = 0, len = 0;
    int low, high;
    
    for(int i = 0; i < S.length(); i++){
        // even part
        low = i - 1;
        high = i;
        while(low>=0 && high<S.length() && S.charAt(low) == S.charAt(high)){
            
            if(high - low + 1 > len){
                len = high - low + 1; //current longest pallindrome length
                si = low;
            }
            low--;
            high++;
        }
        
        // Odd part
        low = i - 1;
        high = i + 1;
        while(low>=0 && high<S.length() && S.charAt(low) == S.charAt(high)){
            
            if(high - low + 1 > len){
                len = high - low + 1; //current longest pallindrome length
                si = low;
            }
            low--;
            high++;
        }
        
    }
    
    if(len == 0){
        return S.substring(si, 1); // no pallindrome at all
    }
    return S.substring(si, si+len);
}

}