class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0||t.length()==0||s.length()<t.length()){
            return "";
        }
        HashMap<Character,Integer> mapT = new HashMap<>();
        for(char n : t.toCharArray()){
            mapT.put(n,mapT.getOrDefault(n,0)+1);
        }
        int req = mapT.size();
        int l = 0;
        int r = 0;
        int create = 0;
        int[] ans = {-1,0,0};
        HashMap<Character,Integer> ssmap = new HashMap<>();
        while(r<s.length()){
            char c = s.charAt(r);
            int count = ssmap.getOrDefault(c,0);
            ssmap.put(c,count+1);
            if(mapT.containsKey(c) && ssmap.get(c).intValue() == mapT.get(c).intValue()){
                create++;
            }
            while(l<=r && req == create){
                c = s.charAt(l);
                if(ans[0]==-1|| ans[0]>=r-l+1){
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                ssmap.put(c,ssmap.get(c)-1);
                if(mapT.containsKey(c) && ssmap.get(c).intValue() < mapT.get(c).intValue()){
                    create--;
                }
                l++;
            }
            r++;
        }
        if(ans[0]==-1){
            return "";
        } 
        return s.substring(ans[1], ans[2]+1);
    }
}
