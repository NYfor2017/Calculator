import Operator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

  /*=========
  * 创建出面板
  * 设两个文本框，一个用于展示输入，一个用于展示结果
  * 定义按键的名字；定义按键数组
  * 设置一个用于保存输入数据的字符串
  * =========*/

public class MyFunction extends JFrame{
    private JPanel pan = new JPanel();
    private JTextField input = new JTextField();
    private JTextField show = new JTextField();
    private String[] buttonName={"sin","cos","tan","OFF","C","←","÷","×","7","8","9","-","4","5","6",
                                    "+","1","2","3","√x","0",".","=","1/x"};
    private JButton[] buttons = new JButton[buttonName.length];
    private String result="";

    /*=========
    * 有参构造函数，用于设框名立一个this
    * 下面有关于页面的代码就不用加多一个this了
    * ========*/

    public MyFunction(String s){
        this();
        setTitle(s);
    }

    /*=========
    * 设置页面
    * 初始化页面
    * 初始化按键们
    * 设置面板
    * 设置两个文本框，一个用于显示输入，一个用于显示结果
    * 把页面元素加入页面中
    * =========*/

    public MyFunction(){

        setLayout(null);
        setSize(300,405);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);


        for(int i = 0;i<buttonName.length;i++) {
            buttons[i] = new JButton(buttonName[i]);
            Font f = new Font("Microsoft YaHei UI",Font.BOLD,18);
            buttons[i].setFont(f);
            buttons[i].setBackground(Color.black);
            buttons[i].setForeground(Color.WHITE);
        }
        buttons[4].setForeground(Color.YELLOW);
        buttons[22].setForeground(Color.YELLOW);


        GridLayout grid = new GridLayout(6,4);
        pan.setLayout(grid);
        pan.setBounds(0,80,300,300);
        pan.setBackground(Color.black);
        for(int i = 0;i<buttonName.length;i++)
            pan.add(buttons[i]);


        input.setBounds(0,0,295,40);
        show.setBounds(0,40,295,40);
        Font f = new Font("Microsoft YaHei UI",Font.BOLD,19);
        Font f1 = new Font("Microsoft YaHei UI",Font.BOLD,14);
        input.setFont(f1);
        show.setFont(f);
        input.setEditable(false);
        input.setHorizontalAlignment(JTextField.RIGHT);
        show.setHorizontalAlignment(JTextField.RIGHT);
        input.setBorder(new EmptyBorder(0,0,0,0));
        show.setBorder(new EmptyBorder(0,0,0,0));
        input.setBackground(Color.black);
        input.setForeground(Color.WHITE);
        show.setBackground(Color.black);
        show.setForeground(Color.WHITE);


        add(pan);
        add(input);
        add(show);

        /*==========
        * 加入监听者和事件处理
        * button[0]实现sin函数的功能
        * buttons[1]实现cos函数的功能
        * buttons[2]实现tan函数的功能
        * buttons[3]实现关闭程序功能
        * buttons[4]实现清空输入框和输出框的功能
        * buttons[5]实现退格键的功能
        * buttons[6]实现"÷"的输入
        * buttons[7]实现"×"的输入
        * buttons[8]实现"7"的输入
        * buttons[9]实现"8"的输入
        * buttons[10]实现"9"的输入
        * buttons[11]实现"-"的输入
        * buttons[12]实现"4"的输入
        * buttons[13]实现"5"的输入
        * buttons[14]实现"6"的输入
        * buttons[15]实现"+"的输入
        * buttons[16]实现"1"的输入
        * buttons[17]实现"2"的输入
        * buttons[18]实现"3"的输入
        * buttons[19]实现"√"运算功能
        * buttons[20]实现"0"输入功能
        * buttons[21]实现"."输入功能
        * buttons[22]实现"="运算功能
        * buttons[23]实现"1/"运算功能
        * ==========*/

        buttons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                 /*=========
                 * 如果输出框中有数据，就对输出数据进行三角函数运算
                 * 而且如果在进行三角函数运算出结果的基础上再进行三角函数运算
                 * 就把输出框中"="后的数据截取下来放在输出框中作为三角函数运算的参数
                 * 不支持在输入框中输入三角函数
                 * 而是将三角函数作为跟"="相似的存在
                 * 以下对于cos、tan函数的处理与此相似
                 * =========*/

                if(!show.getText().isEmpty()){
                    int numEqual = show.getText().indexOf("=");
                    if(numEqual!=-1)
                        show.setText(show.getText().substring(numEqual+1,show.getText().length()));
                    double outResult = Double.parseDouble(show.getText());
                    show.setText("sin"+show.getText()+"="+String.valueOf(Math.sin(Math.PI*outResult/180)));
                }
            }
        });
        buttons[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!show.getText().isEmpty()){
                    int numEqual = show.getText().indexOf("=");
                    if(numEqual!=-1)
                        show.setText(show.getText().substring(numEqual+1,show.getText().length()));
                    double outResult = Double.parseDouble(show.getText());
                    show.setText("cos"+show.getText()+"="+String.valueOf(Math.cos(Math.PI*outResult/180)));

                }
            }
        });
        buttons[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!show.getText().isEmpty()){
                    int numEqual = show.getText().indexOf("=");
                    if(numEqual!=-1)
                        show.setText(show.getText().substring(numEqual+1,show.getText().length()));
                    double outResult = Double.parseDouble(show.getText());
                    show.setText("tan"+show.getText()+"="+String.valueOf(Math.tan(Math.PI*outResult/180)));
                }
            }
        });
        buttons[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttons[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input.setText("");
                show.setText("");
            }
        });

        /*=========
          如果输入框里没有数据，那么就返回
          如果输入框里有数据，用input.getText().substring()方法返回从第0位到原先最后的字符的前一
         */

        buttons[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(show.getText().isEmpty())
                    return;
                else
                    show.setText(show.getText().substring(0,show.getText().length()-1));
            }
        });
        buttons[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                /*=========
                * 如果输入的第一个字符是"+"，则设置为"0÷"
                * 如果输入框中有数据，那就把，输入框中的数据、输入的数字和"÷"加入输入框中
                * 如果输入框中没有数据，那就直接把输入的数字和"÷"加入输入框中
                * 如果重复输入运算符，只取最后一个输入的运算符
                * 如果输出框中有"="出现（在进行三角函数、开方、倒数运算之后），则在输入框显示"="后面的数据
                * 以下关于运算符的处理类似此运算符的处理
                * =========*/

                if (show.getText().isEmpty() && input.getText().isEmpty())
                    input.setText("0÷");
                if(!input.getText().isEmpty())
                    input.setText(input.getText()+show.getText()+"÷");
                else
                    input.setText(show.getText()+"÷");
                if(input.getText().indexOf("-÷")!=-1||input.getText().indexOf("+÷")!=-1
                        ||input.getText().indexOf("÷÷")!=-1||input.getText().indexOf("×÷")!=-1)
                    input.setText(input.getText().substring(0,input.getText().length()-2)+"÷");
                int numEqual = show.getText().indexOf("=");
                if(numEqual!=-1)
                    input.setText(show.getText().substring(numEqual+1,show.getText().length())+"+");
                show.setText("");
            }
        });
        buttons[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (show.getText().isEmpty() && input.getText().isEmpty()) {
                    input.setText("0×");
                }
                if(!input.getText().isEmpty())
                    input.setText(input.getText()+show.getText()+"×");
                else
                    input.setText(show.getText()+"×");
                if(input.getText().indexOf("-×")!=-1||input.getText().indexOf("+×")!=-1
                        ||input.getText().indexOf("÷×")!=-1||input.getText().indexOf("××")!=-1)
                    input.setText(input.getText().substring(0,input.getText().length()-2)+"×");
                int numEqual = show.getText().indexOf("=");
                if(numEqual!=-1)
                    input.setText(show.getText().substring(numEqual+1,show.getText().length())+"×");
                show.setText("");
            }
        });
        buttons[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                /*=========
                 * 直接显示数字
                 * 以下数字类似"7“的处理
                 * =========*/

                show.setText(show.getText()+"7");
            }
        });
        buttons[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                show.setText(show.getText()+"8");
            }
        });
        buttons[10].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                show.setText(show.getText()+"9");
            }
        });
        buttons[11].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (show.getText().isEmpty() && input.getText().isEmpty()) {
                    input.setText("0-");
                }
                if(!input.getText().isEmpty())
                    input.setText(input.getText()+show.getText()+"-");
                else
                    input.setText(show.getText()+"-");
                if(input.getText().indexOf("--")!=-1||input.getText().indexOf("+-")!=-1
                        ||input.getText().indexOf("÷-")!=-1||input.getText().indexOf("×-")!=-1)
                    input.setText(input.getText().substring(0,input.getText().length()-2)+"-");
                int numEqual = show.getText().indexOf("=");
                if(numEqual!=-1)
                    input.setText(show.getText().substring(numEqual+1,show.getText().length())+"-");
                show.setText("");
            }
        });
        buttons[12].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                show.setText(show.getText()+"4");
            }
        });
        buttons[13].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                show.setText(show.getText()+"5");
            }
        });
        buttons[14].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                show.setText(show.getText()+"6");
            }
        });
        buttons[15].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (show.getText().isEmpty() && input.getText().isEmpty()) {
                    input.setText("0+");
                }
                if(!input.getText().isEmpty())
                    input.setText(input.getText()+show.getText()+"+");
                else
                    input.setText(show.getText()+"+");
                if(input.getText().indexOf("-+")!=-1||input.getText().indexOf("++")!=-1
                        ||input.getText().indexOf("÷+")!=-1||input.getText().indexOf("×+")!=-1)
                    input.setText(input.getText().substring(0,input.getText().length()-2)+"+");
                int numEqual = show.getText().indexOf("=");
                if(numEqual!=-1)
                    input.setText(show.getText().substring(numEqual+1,show.getText().length())+"+");
                show.setText("");
            }
        });
        buttons[16].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                show.setText(show.getText()+"1");
            }
        });
        buttons[17].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                show.setText(show.getText()+"2");
            }
        });
        buttons[18].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                show.setText(show.getText()+"3");
            }
        });
        buttons[19].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!show.getText().isEmpty()) {

                    /*=========
                    * 当输出框不为空时
                    * 如果输入的第一个字符是"√",则清空输入框
                    * 如果是用开方过的数据继续运算，把"="后的数据返回并进行再次开方运算
                    * 如果不是，则先判断是否为负数，是的话就输出"被开方数不能为负数
                    * 如果不是负数，就进行正常的开方运算
                    * ==========*/

                    if(show.getText().substring(0,show.getText().length()).equals("√"))
                        show.setText("");
                    int numEqual = show.getText().indexOf("=");
                    if(numEqual!=-1) {
                        show.setText(show.getText().substring(numEqual + 1, show.getText().length()));
                        show.setText("√" + show.getText() + "=" + Math.sqrt(Double.parseDouble(show.getText())));
                    }
                    else{
                        if (Double.parseDouble(show.getText()) < 0) {
                            show.setText("被开方数不能为负数");
                            input.setText("");
                        }
                        else
                            show.setText("√" + show.getText() + "=" + Math.sqrt(Double.parseDouble(show.getText())));
                    }
                }
            }
        });
        buttons[20].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                show.setText(show.getText()+"0");
            }
        });
        buttons[21].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                /* =========
                 * 先直接输一个"."
                 * 如果没有其他数据先于"."输入，那么直接在输入框中显示"0."
                 * 以下操作是为了避免一个数中有多个"."：
                 * 先记录"."第一次出现的位置，把输入的数据转化成字符数组，以便搜查多余的"."
                 * 然后搜查这个位置之后是否还有"."出现
                 * 如果有，那就除了那个多出来的"."外其余的字符串返回给输入框
                 * =========*/

                show.setText(show.getText()+".");
                if(show.getText().isEmpty())
                    input.setText("0.");
                int numPoint = show.getText().indexOf(".");
                char[] fouPoint =
                        show.getText().substring(numPoint+1,show.getText().length()).toCharArray();
                int numP=0;
                for(int i=0;i<fouPoint.length;i++)
                    if(fouPoint[i]=='.')
                        numP++;
                if(numP>0)
                    show.setText(show.getText().substring(0,show.getText().length()-1));
            }
        });
        buttons[22].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                /*=========
                 * 把输入框和最后输入的数据都放在输入框中
                 * 将result设为字符串参数给operatorAct方法处理
                 * 然后再返回一个double类型的值
                 * 再用String.valueOf()函数把double类型的值转化为字符用于输出框的数据显示
                 * 先处理，如果进行完三角函数、开方、倒数的运算之后
                 * 再处理不完整的表达式，方法是直接将运算符前后的数据进行运算
                 * 但是如果除数为0，则返回"除数不能为0“
                 * 最后再进行四则运算
                 * 最最后，把输入框清空
                 * =========*/

                int numEqual = show.getText().indexOf("=");
                if(numEqual!=-1) {
                    input.setText(input.getText()+show.getText().substring(numEqual+1,show.getText().length()));
                    show.setText("");
                }
                input.setText(input.getText()+show.getText());
                operator op = new operator();
                result = input.getText();
                if(result.substring(input.getText().length()-1,result.length()).equals("÷")
                        ||(result.substring(result.length()-1,result.length()).equals("×"))
                        ||(result.substring(result.length()-1,result.length()).equals("+"))
                        ||(result.substring(result.length()-1,result.length()).equals("-"))){
                    show.setText(String.valueOf(op.operatorAct(result+
                            result.substring(0,result.length()-1))));
                }
                else {
                    int numDivison = input.getText().indexOf("÷");
                    if (show.getText().equals("0")||show.getText().equals("0.0")||show.getText().equals("Infinity")
                            ||input.getText().substring(numDivison+1,input.getText().length()).equals("0.0"))
                        show.setText("除数不能为0");
                    else{
                        String calculated = String.valueOf(op.operatorAct(result));
                        show.setText(calculated);
                    }
                }
               input.setText("");
            }
        });
        buttons[23].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                /*=========
                 * 将result设为字符串参数
                 * double化的outResult用于判断操作数是否为0
                 * 若操作数为0，则返回"除数不能为0"
                 * 若操作数不为0，就进行倒数运算
                 * =========*/

                String result = show.getText();
                double outResult = Double.valueOf(result);
                operator op = new operator();
                if(!show.getText().isEmpty()){
                    if(outResult==0)
                        show.setText("除数不能为0");
                    else
                        show.setText(String.valueOf(1/op.operatorAct(result)));
                }
            }
        });
    }
}
