class Solution {
    public int countSubstrings(String s) {
        if(s==null||s.length()<1){
            return 0;
        }
        int c = 0;
        int l = 0;
        int r = 0;
        for(int i=0;i<s.length();i++){
            c+=checkp(s,i,i);
            c+=checkp(s,i,i+1);
        }
        return c;
    }
    public int checkp(String s,int l,int r){
        int c = 0;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
            c++;
        }
        return c;
    }
}
