import java.util.HashMap;

public class Solution208 {
    public static void main(String[] args) {
        Trie tire =new Trie();
        tire.insert("apple");
        System.out.println(tire.search("apple"));
        System.out.println(tire.search("app"));
        System.out.println(tire.search("apples"));
        System.out.println(tire.startsWith("ap"));
        tire.insert("app");
        System.out.println(tire.search("app"));
    }
}

class Trie {
    static int DefaultNum=26;
    int num=0;
    Trie [] son =new Trie[DefaultNum] ;


    /** Initialize your data structure here. */
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word != null && word.length()!=0)
        {
            char [] chars= word.toCharArray();
            if(son[chars[0]-'a'] == null)
                son[chars[0]-'a']= new Trie();
            Trie temp=son[chars[0]-'a'];
            for(int i=1;i<chars.length;i++)
            {
                if(temp.son[chars[i]-'a'] == null)
                    temp.son[chars[i]-'a']= new Trie();
                temp=temp.son[chars[i]-'a'];
            }
            temp.num++;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.length()==0)
            return false;
        char [] chars= word.toCharArray();
        Trie temp=this;
        for(int i=0;i<chars.length;i++)
        {
            if(temp.son[chars[i]-'a'] == null)
                return false;
            temp=temp.son[chars[i]-'a'];
        }
        if(temp.num>0)
            return true;
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length()==0)
            return false;
        char [] chars= prefix.toCharArray();
        Trie temp=this;
        for(int i=0;i<chars.length;i++)
        {
            if(temp.son[chars[i]-'a'] == null)
                return false;
            temp=temp.son[chars[i]-'a'];
        }
        return true;
    }
}

/*递归



class Trie {
    static int DefaultNum=26;
    int num=0;
    Trie [] son =new Trie[DefaultNum] ;



    public Trie() {
    }


    public void insert(String word) {
        if(word != null && word.length()!=0)
        {
            if(son[word.charAt(0)-97] == null)
                son[word.charAt(0)-97]= new Trie();
            if(word.length()<=1)
            {
                son[word.charAt(0)-97].num++;
            }
            else
            {
                son[word.charAt(0)-97].insert(word.substring(1));
            }
        }
    }


    public boolean search(String word) {
        if(word == null || word.length()==0)
            return false;
        if(word.length()>=1 &&  son[word.charAt(0)-97]!=null) {
            if( word.length() ==1 && son[word.charAt(0)-97].num>0)
                return true;
            else
                return son[word.charAt(0)-97].search(word.substring(1));
        }
        return false;
    }


    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length()==0)
            return false;
        if(prefix.length()>=1 &&  son[prefix.charAt(0)-97]!=null) {
            if( prefix.length() ==1 && son[prefix.charAt(0)-97] !=null)
                return true;
            else
                return son[prefix.charAt(0)-97].startsWith(prefix.substring(1));
        }
        return false;
    }
}
*/