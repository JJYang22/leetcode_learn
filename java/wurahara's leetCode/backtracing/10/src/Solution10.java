public class Solution10 {
    public static void main(String [] args)
    {
        String s1="aa";
        String p1="a";
        String s2="aabbcd";
        String p2="a*.";
        String s3="asd";
        String p3=".*c*c*";
        String s4="aab";
        String p4="c*a*b";
        String s5="mississippi";
        String p5="mis*is*p*.";
        Solution s =new Solution();
//        s.isMatch(s1,p1);
     System.out.println(s.isMatch(s3,p3));
 //       System.out.println(s.isMatch(s5,p5));
//        s.isMatch(s4,p4);
//        s.isMatch(s5,p5);


    }
}
//'.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null)
        {
            if (p == null)
                return true;
            else
                return false;
        }
        else
        {
            if(p == null)
                return false;
            else
            {
                return  temp(s,p);
            }
        }
    }
    private boolean temp(String s,String p)
    {
        boolean ans = false;
        int s_end = 1;
        int p_end = 1;
        if( p.length() == 0 && s.length() == 0 )
            return true;
        if (p.length() > 1)
        {
            if ( p.charAt(1) ==  '*' )
            {
                if( s.length() == 0 )
                    if(p.length() > 2)
                        return temp(s,p.substring(2));
                    else
                        return true;
                p_end++;
                if ( p.charAt(0) == '.')
                {
                    s_end = 0;
                    if ( p_end >= p.length() )
                        return true;
                    else
                    {
                        while ( s_end <= s.length() )
                        {
                            ans = temp(s.substring(s_end),p.substring(p_end));
                            if( ans == true )
                                break;
                            s_end ++ ;
                        }
                        return ans;
                    }
                }
                if ( p.charAt(0) == s.charAt(0) )
                {
                    if(p.length()>=4 && p.substring(2,4).equals(p.substring(0,2)))
                        p_end+=2;
                    ans=temp(s,p.substring(p_end));
                    while(s_end <= s.length() && s.charAt(s_end-1) == p.charAt(0) && ans== false)
                    {
                        ans=temp(s.substring(s_end),p.substring(p_end));
                        s_end++;
                    }
                    return ans;
                }
                else
                {
                    if(p_end <p.length())
                    {
                        return  temp( s , p.substring( p_end ) );
                    }

                    else
                        return false;
                }
            }
            else {
                if (s.length() == 0) {
                    return false;
                }
            }
        }
        if( s.length() == 0 || p.length() == 0 )
            return false;
        if ( p.charAt(0) == s.charAt(0) || p.charAt(0) == '.' )
        {
            if (s_end <= s.length() && p_end <= p.length())
            {
                return temp( s.substring(s_end), p.substring(p_end) );
            }
            if (s_end >= s.length() && p_end >= p.length())
                return true;
        }
        return ans;
    }
}

/*
    private boolean temp(String s,String p)
    {
        System.out.println();
        System.out.println("s="+s);
        System.out.println("p="+p);

        boolean ans = false;
        int s_end = 1;
        int p_end = 1;
        if( p.length() == 0 && s.length() == 0 )
            return true;
        if (p.length() > 1)
        {
            if ( p.charAt(1) ==  '*' )
            {
                if( s.length() == 0 )
                    if(p.length() > 2)
                        return false;
                    else
                        return true;
                p_end++;
                if ( p.charAt(0) == '.')
                {
                    s_end = 0;
                    if ( p_end >= p.length() )
                        return true;
                    else
                    {
                        while ( s_end < s.length() )
                        {
                            System.out.println("s_end="+s_end);
                            System.out.println("p_end="+p_end);
                            ans = temp(s.substring(s_end),p.substring(p_end));
                            if( ans == true )
                                break;
                            s_end ++ ;
                        }
                        return ans;
                    }
                }
                if ( p.charAt(0) == s.charAt(0) )
                {
                    while ( p_end < p.length() && p.charAt(p_end) == p.charAt(0) )
                        p_end++;
                    if(p_end < p.length() && p.charAt(p_end) == '*' )
                        p_end--;
                    while ( s_end < s.length() && s.charAt(s_end) == s.charAt(0) )
                        s_end++;
                    if ( s_end >= p_end - 2 )
                    {
                        if (s_end <= s.length() && p_end <= p.length())
                        {
                            System.out.println("s_end="+s_end);
                            System.out.println("p_end="+p_end);
                            return temp(s.substring(s_end), p.substring(p_end));
                        }
                        else
                            return true;
                    }
                }
                else
                {
                    if(p_end <p.length())
                    {
                        System.out.println("p_end="+p_end);
                        return  temp( s , p.substring( p_end ) );
                    }

                    else
                        return false;
                }
            }
            else
                if( s.length() == 0 )
                {
                    return false;
                }
        }
        if( s.length() == 0 || p.length() == 0 )
            return false;
        if ( p.charAt(0) == s.charAt(0) || p.charAt(0) == '.' )
        {
            if (s_end <= s.length() && p_end <= p.length())
            {
                System.out.println("s_end="+s_end);
                System.out.println("p_end="+p_end);
                return temp( s.substring(s_end), p.substring(p_end) );
            }
            if (s_end >= s.length() && p_end >= p.length())
                return true;
        }
        return ans;
    }
   */