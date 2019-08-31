import java.util.Map;

public class Solution677 {
    public static void main(String[] args) {
        MapSum obj =new MapSum();
        obj.insert("apple",3);
        System.out.println(obj.sum("ap"));
        obj.insert("applesc",5);
        obj.insert("apple",4);
        System.out.println(obj.sum("apple"));
    }
}
class MapSum {
    MapSum [] son = new MapSum[26];
    int val;
    /** Initialize your data structure here. */
    public MapSum() {

    }
    public MapSum search(String key)
    {

        char[] chars = key.toCharArray();
        MapSum temp=this;
        for(int i=0;i<chars.length;i++)
        {
            if(temp.son[chars[i]-'a']==null)
                temp.son[chars[i]-'a']=new MapSum();
            temp=temp.son[chars[i]-'a'];
        }
        return temp;
    }
    public void insert(String key, int val) {

        search(key).val=val;
    }
    public int sum(String prefix) {
        return valsum(search(prefix));
    }
    public int valsum(MapSum root)
    {

        int sum=root.val;
        for(int i=0;i<26;i++)
        {
            if(root.son[i]!=null)
                sum+=valsum(root.son[i]);
        }
        return sum;
    }

}