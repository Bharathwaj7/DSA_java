class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return Collections.emptyList();
        
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> ans = new ArrayList<>();
        solve(digits, 0, map, new StringBuilder(), ans);
        return ans;
    }

    void solve(String digits, int idx, Map<Character,String> map, StringBuilder sb, List<String> ans){
        if(idx >= digits.length()) {
            ans.add(sb.toString());
            return;
        }

        for(char ch : map.get(digits.charAt(idx)).toCharArray()){
            sb.append(ch);
            solve(digits, idx+1, map, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
