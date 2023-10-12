public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> result=new LinkedListDeque<>();
        for(int i=0;i<word.length();i++){
            result.addLast(word.charAt(i));
        }
        return result;
    }
    public boolean isPalindrome(String word){
        if(word.length()<=1)return true;
        Deque<Character> list=wordToDeque(word);
        int count=list.size()/2;
        Character ch1,ch2;
        for(int i=0;i<count;i++){
            ch1=list.removeFirst();
            ch2=list.removeLast();
            if(!ch1.equals(ch2))
                return false;
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length()<=1)return true;
        Deque<Character> list=wordToDeque(word);
        int count=list.size()/2;
        for(int i=0;i<count;i++){
            if(!cc.equalChars(list.removeFirst(),list.removeLast()))
                return false;
        }
        return true;
    }
}
