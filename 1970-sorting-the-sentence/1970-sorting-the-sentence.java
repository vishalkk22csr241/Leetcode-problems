class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        int len = words.length;
        String[] res = new String[len];
        for(String word: words){
            int index = word.charAt(word.length() - 1) - '0';
            res[index - 1] = word.substring(0, word.length() - 1);
        }
        return String.join(" ", res); 
    }
}