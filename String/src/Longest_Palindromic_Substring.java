class Solution {
    public String longestPalindrome(String s) {
        if (s==null||s.length()<1){
            return "";
        }
        int left = 0;
        int rigth = 0;
        for(int i=0;i<s.length();i++){
            int len1 = checkp(s,i,i);
            int len2 = checkp(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > rigth - left){
                left = i-(len-1)/2;
                rigth = i + len/2; 
            }
        }
        return s.substring(left,rigth+1);
    }
    public int checkp(String s,int left,int rigth){
        while(left>=0 && rigth<s.length() && s.charAt(left) == s.charAt(rigth)){
            left--;
            rigth++;
        }
        return rigth-left-1;
    }
}
