//You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. 
//Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> j = new HashSet<Character>();
        for(int i=0;i<jewels.length();i++){
            j.add(jewels.charAt(i));
        }
        int x =0;
        for(int i=0;i<stones.length();i++){
            if(j.contains(stones.charAt(i))) x++;
        }
        return x;
    }
}
