class TrieNode{
    Map<Character, TrieNode> children;
    public TrieNode() {
        this.children = new HashMap<>();
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root; 
        for(char c: word.toCharArray()){
            if(!node.children.containsKey(c)){
                node.children.put(c,new TrieNode());
            }
            node = node.children.get(c);
        }
        node.children.put('*',new TrieNode());
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }
        if(node.children.get('*')!=null) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root; 
        for(char c: prefix.toCharArray()){
            if(!node.children.containsKey(c)){
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */