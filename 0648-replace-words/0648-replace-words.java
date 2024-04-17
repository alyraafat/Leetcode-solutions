class TrieNode {
    // you can store data at nodes if you wish
    int data;
    Map<Character, TrieNode> children;
    TrieNode() {
        this.children = new HashMap<>();
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = buildTrie(dictionary);
        String[] arr = sentence.split(" ");
        String ans = "";
        for(int i=0;i<arr.length;i++){
            String word = arr[i];
            TrieNode curr = root;
            String common = search(curr,word);
            if(!common.equals("")){
                ans+=common;
            }else{
                ans+=word;
            }
            if(i!=arr.length-1) ans+=" ";
        }
        return ans;
    }
    public String search(TrieNode curr, String word){
        String common = "";
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!curr.children.containsKey(c)){
                if(curr.data==0) common="";
                break;
            }else{
                common+=c;
                curr = curr.children.get(c);
                if(curr.data==1) break;
            }
        }
        return common;
    }
    public TrieNode buildTrie(List<String> words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode curr = root;
            for (char c: word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }

                curr = curr.children.get(c);
            }
            curr.data = 1;
        }
        return root;
    }
}