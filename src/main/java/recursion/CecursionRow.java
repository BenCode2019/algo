package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Ben
 * @Date: 2018/10/30 17
 * @Description:
 */
public class CecursionRow {

    public int getRow(int n){
        System.out.println("current row " + n);
        if(n == 1){
            return 1;
        }
        return getRow(n-1);
    }

    public Map map = new HashMap();

    public int getStep(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(map.containsKey(n)){
            return Integer.valueOf(map.get(n).toString());
        }
        int result = getStep(n-1) + getStep(n-2);
        System.out.println(result);
        map.put(n,result);
        return result;
    }

    public static void main(String[] args) {
//        new CecursionRow().getRow(5);
        int rs = new CecursionRow().getStep(5);
        System.out.println(rs);
    }
}
