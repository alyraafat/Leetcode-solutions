class Pair {
    String node;
    int steps;
    Pair(String node, int steps) {
        this.node = node;
        this.steps = steps;
    }
}
class Solution {
    char[] choices = new char[]{'A','C','G','T'};
    HashSet<String> bankSet = new HashSet<String>();
    HashSet<String> seen = new HashSet<String>();
    Queue<Pair> q = new LinkedList<Pair>();
    public int minMutation(String startGene, String endGene, String[] bank) {
        for(String gene: bank){
            bankSet.add(gene);
        }
        bankSet.add(startGene);
        seen.add(startGene);
        q.add(new Pair(startGene,0));

        return minHelper(startGene,endGene);
    }
    public int minHelper(String startGene, String endGene){
        while(!q.isEmpty()){
            Pair gene = q.remove();
            String str = gene.node;
            int steps = gene.steps;
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                for (char choice: choices) {
                    if(choice==c){
                        continue;
                    }
                    String newGene = str.substring(0, i) + ("" + choice) + str.substring(i + 1);
                    if(!seen.contains(newGene)&&bankSet.contains(newGene)){
                        seen.add(newGene);
                        if(newGene.equals(endGene)) return steps+1;
                        q.add(new Pair(newGene,steps+1));
                    }
                }
            }
        }
        return -1;
        
        
    }
}