
import java.math.BigDecimal;


public class operator {

    /*=========定义操作方法=========*/

    public double operatorAct(String result) {

        /*=========定义一个inResult用于传送结果=========*/

        double inResult = 0;

        /*=========搜查并返回运算符的位置=========*/

        int a1 = result.indexOf("+");
        int a2 = result.indexOf("-");
        int a3 = result.indexOf("×");
        int a4 = result.indexOf("÷");

        /*=========如果没有运算符的出现，把输入的字符串转成Double型返回========*/

        if (a1 == -1 && a2 == -1 && a3 == -1 && a4 == -1)
            return Double.parseDouble(result);

        /*=========
        * 以下是对于各个运算符的操作
        * 用递归法，把运算符之前的字符串作为参数进行运算
        * =========*/

        if (a1 != -1) {
            inResult = operatorAct(result.substring(0, a1)) +
                    operatorAct(result.substring(a1 + 1, result.length()));
            return inResult;
        }
        if (a2 != -1) {
                inResult = operatorAct(result.substring(0, a2)) -
                        operatorAct(result.substring(a2 + 1, result.length()));
            return inResult;
        }
        if (a3 != -1) {
            inResult = operatorAct(result.substring(0, a4)) *
                    operatorAct(result.substring((a4 + 1), result.length()));
            BigDecimal b = new BigDecimal(String .valueOf(inResult));
            inResult = b.setScale(15, BigDecimal.ROUND_HALF_UP).doubleValue();
            return inResult;
        }
        if (a4 != -1) {

            /*=========
             * 因为数据时double类型的，所以在做除法运算时会涉及到精度问题
             * 先把数据设为BigDecimal类型的
             * 然后再把数据用setScale方法转成String类型后
             * 最后再用doubleValue转成double类型的数据
             * =========*/

            inResult = operatorAct(result.substring(0, a4)) /
                    operatorAct(result.substring((a4 + 1), result.length()));
            BigDecimal b = new BigDecimal(String .valueOf(inResult));
            inResult = b.setScale(15, BigDecimal.ROUND_HALF_UP).doubleValue();
            return inResult;
        }
        return Integer.parseInt(result);
    }
}
