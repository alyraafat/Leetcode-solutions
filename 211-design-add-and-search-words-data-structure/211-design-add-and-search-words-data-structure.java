class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!curr.children.containsKey(c)){
                curr.children.put(c,new TrieNode());
            }
            curr=curr.children.get(c);
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        // TrieNode curr = root;
        // for(int i=0;i<word.length();i++){
        //     char c = word.charAt(i);
        //     if(c!='.'&&!curr.children.containsKey(c)){
        //         return false;
        //     }
        //     else if(c=='.'){
        //         if(searchHelper(word.substring(i+1),curr)) return true;
        //         return false;
        //     }
        //     curr=curr.children.get(c);
        // }
        // return curr.isWord;
        return searchHelper(word,root);
    }
    public boolean searchHelper(String word,TrieNode node){
        // for(char x: curr.children.keySet()){
        //     TrieNode node = curr.children.get(x);
        //     for(int i=0;i<word.length();i++){
        //         char c = word.charAt(i);
        //         if(c!='.'&&!node.children.containsKey(c)){
        //             return false;
        //         }
        //         else if(c=='.'){
        //             if(searchHelper(word.substring(i+1),node)) return true;
        //         }
        //         node=node.children.get(c);
        //     }
        //     if(node.isWord) return true;
        // }
        // return false;
        TrieNode curr = node;
        for(int i=0;i<word.length()&&curr!=null;i++){
            char c = word.charAt(i);
            if(c!='.'&&!curr.children.containsKey(c)){
                return false;
            }
            else if(c=='.'){
                for(char x: curr.children.keySet()){
                    TrieNode n2 = curr.children.get(x);
                    if(searchHelper(word.substring(i+1),n2)) return true;
                    
                }
                return false;
            }
            curr=curr.children.get(c);
        }
        return curr!=null?curr.isWord:false;
    }
}
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    TrieNode() {
        this.children = new HashMap<>();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */