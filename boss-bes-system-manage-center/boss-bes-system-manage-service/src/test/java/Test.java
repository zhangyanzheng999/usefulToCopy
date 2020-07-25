import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:测试类，为了测试Map和value的转换
 * @author:zyz
 * @time:2020/7/11-9:28
 */
public class Test {
    @org.junit.Test
    public void test(){
        Map map=new HashMap<>();
        map.put(1,"hhh");
        map.put(2,"yyy");
        List list=new ArrayList(map.values());
        System.out.println(list);
    }
}
