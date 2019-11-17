package DataStructure.MyBinarySearch;

/**
 * @Author Voidmian
 * @Date 2019/11/15 15:10
 */
public class NextGreatestLetter744 {
    static public void test(){
        NextGreatestLetter744 nextGreatestLetter744 = new NextGreatestLetter744();
        char[] letters={'e','e','e','e','e','e','n','n','n','n'};

        System.out.println(nextGreatestLetter744.nextGreatestLetter(letters,'n'));
    }
    public char nextGreatestLetter(char[] letters, char target) {
        int begin = 0;
        int end = letters.length - 2;
        int mid = begin + (end - begin) / 2;
        while (begin < end){
            if(letters[mid] == target && letters[mid + 1]>target)
                return letters[mid + 1];
            if(letters[mid] <= target){
                begin = mid + 1;
            } else {
                end = mid;
            }
            mid = begin + (end - begin) / 2;
        }
        if(letters[mid] > target)
            return letters[mid];
        if(letters[mid] == target && letters[mid + 1]>target)
            return letters[(mid+1)];
        if(letters[mid + 1] <= target )
            return letters[0];
        else
            return letters[mid + 1];
    }
}
