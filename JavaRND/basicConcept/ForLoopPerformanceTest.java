package basicConcept;


public class ForLoopPerformanceTest
{
    private static List&lt;Integer&gt; list = new ArrayList&lt;&gt;();
    private static long startTime;
    private static long endTime;
    static
    {
        for(int i=0; i &lt; 1_00_00_000; i++)
        {
            list.add(i);
        }
    }
    
    @SuppressWarnings(&quot;unused&quot;)
    public static void main(String[] args)
    {
        //Type 1
        startTime = Calendar.getInstance().getTimeInMillis();
        for(Integer i : list)
        {
            //
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println(&quot;For each loop :: &quot; + (endTime - startTime) + &quot; ms&quot;);
 
        //Type 2
        startTime = Calendar.getInstance().getTimeInMillis();
        for(int j = 0; j &lt; list.size() ; j++)
        {
            //
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println(&quot;Using collection.size() :: &quot; + (endTime - startTime) + &quot; ms&quot;);
 
        //Type 3
        startTime = Calendar.getInstance().getTimeInMillis();
        int size = list.size();
        for(int j = 0; j &lt; size ; j++)
        {
            //System.out.println(j);
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println(&quot;Using [int size = list.size(); int j = 0; j &lt; size ; j++] :: &quot; + (endTime - startTime) + &quot; ms&quot;);
 
        //Type 4
        startTime = Calendar.getInstance().getTimeInMillis();
        for(int j = list.size(); j &gt; size ; j--)
        {
            //System.out.println(j);
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println(&quot;Using [int j = list.size(); j &gt; size ; j--] :: &quot; + (endTime - startTime) + &quot; ms&quot;);
    }
}