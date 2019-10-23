import java.util.ArrayList;

import java.util.Collections;

public class Solution {
    public static void main(String[] args)
    {
        String [] Logs=new String [5];
        Logs[0]="a1 9 2 3 1";
        Logs[1]="g1 act car";
        Logs[2]="zo4 4 7";
        Logs[3]="ab1 off key dog";
        Logs[4]="a8 act zoo";
        Solution937 s=new Solution937();
        String [] ans=s.reorderLogFiles1(Logs);

        for (String t :ans)
        {
            System.out.println(t);
        }

    }
}
class Solution937
{
    public String [] reorderLogFiles1(String [] logs)
    {
        int count_letter=0;
        int count_num=0;
        ArrayList <String> anslogs=new ArrayList<String>(logs.length);
        for(String s:logs)
        {
           if( (s.substring(s.indexOf(" ")+1)).charAt(0)<'a')
           {
               anslogs.add(count_letter+count_num,(String)s);
               count_num++;
           }
           else
           {
               anslogs.add(count_letter,s);
               count_letter++;
           }
        }
        for(int i=0;i<count_letter;i++)
        {
            for(int j=count_letter-1;j>i;j--)
            {
                if(CmpLogs(anslogs.get(j),anslogs.get(j-1))<0)
                {
                    Collections.swap(anslogs,j,j-1);
                }
            }
        }
        return anslogs.toArray(logs);
    }




    public String [] reorderLogFiles(String [] logs)
    {
        String [] anslogs=new String [logs.length];
        int length_letter=0;
        boolean [] NumOrLetter= new boolean[logs.length];

        for(int i=0;i<logs.length;i++)
        {

           int  index=logs[i].indexOf(" ")+1;
            String key=logs[i].substring(index);
            if(key.charAt(0) < 'a')
                NumOrLetter[i] = false;
            else
            {
                NumOrLetter[i] = true;
                length_letter++;
            }
        }

        for(int i=0,j=0;(i+j)<logs.length;)
        {
            if(NumOrLetter[i+j] ==  false)
            {
                anslogs[j+length_letter]=logs[i+j];
                j++;
            }
            else
            {
                anslogs[i]=logs[i+j];
                i++;
            }
        }


        for(int i=0;i<length_letter;i++)
        {
            for(int j=length_letter-1;j>i;j--)
            {
                if(CmpLogs(anslogs[j],anslogs[j-1])<0)
                {
                    String temp=anslogs[j];
                    anslogs[j]=anslogs[j-1];
                    anslogs[j-1]=temp;
                }
            }
        }
    return anslogs;
    }

    private int CmpLogs(String s1,String s2)
    {
        int  index=s1.indexOf(" ")+1;
        String key1=s1.substring(index);
        index=s2.indexOf(" ")+1;
        String key2=s2.substring(index);
        int ans =key1.compareTo(key2);
        if (ans == 0)
            return s1.compareTo(s2);
        else
            return ans;
    }
}
