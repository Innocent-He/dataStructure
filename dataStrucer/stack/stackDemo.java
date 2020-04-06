package stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author He
 * @Date 2020/3/27 10:38
 * @Version 1.0
 */
public class stackDemo {
    public static void main(String[] args) {
        stackArray stackArray=new stackArray(5);
    }
}
class stackArray{
    private int maxSize;
    private int top=-1;
    private int[] stack;
    public  stackArray(int maxSize){
        this.maxSize=maxSize;
        this.stack=new int[this.maxSize];
    }
    public int peak(){
        return stack[top];
    }
    public boolean isFull(){
        return top==maxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public void push(int data){
        if (!isFull()) {
            top++;
            stack[top] = data;
            return;
        }
        if (isFull()) {
            System.out.println("栈已满");
        }
    }
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int value=stack[top];
        top--;
        return value;
    }
    public void showAll(){
        if (isEmpty()){
            System.out.println("没有数据");
        }
        for (int i=top;i>=0;i--){
            System.out.println(pop());
        }
    }

}
//模拟计算器
class calculator{
    private String equal;
    stackArray number=new stackArray(10);
    stackArray fuhao=new stackArray(10);
    int num1;
    int num2;
    int oper;
    public calculator(String equal){
        this.equal=equal;
    }

    public calculator() {
    }

    public  int compute(int num1, int num2, int oper){
        int result=0;
        switch (oper){
            case('+') : result=num1+num2;break;
            case('-') : result=num2-num1;break;
            case('*') : result=num1*num2;break;
            case('/') : result=num2/num1;break;
        }
        return result;
    }
    public int properity(int oper){
        if (oper=='+'||oper=='-'){
            return 0;
        }
        if (oper=='*'||oper=='/'){
            return 1;
        }else {
            return -1;
        }
    }

    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    public int conputeOver(){
        int index=0;
        while(true){
            //判断是不是符号
            char x=equal.charAt(index);
            if (isOper(x)){
                //如果当前符号栈顶为空则直接入栈
                if (fuhao.isEmpty()){
                    fuhao.push(x);

                }else{
                    //如果当前符号优先级小于等于栈顶符号则先进行运算
                    if (properity(x)<=properity(fuhao.peak())){
                        num1=number.pop();
                        num2=number.pop();
                         oper= fuhao.pop();
                        number.push(compute(num1,num2,oper));
                        fuhao.push(x);
                    }else{
                        fuhao.push(x);
                    }
                }

            }

            //如果是数字则直接入栈
            else{
                String num=String.valueOf(x);
                for (int i=index+1;i<equal.length();i++){
                    if (isOper(equal.charAt(i))){

                        break;
                    }else {
                        num=num+equal.charAt(i);
                        index++;
                    }
                }

                number.push(Integer.parseInt(num));
            }
            index++;
            if (index==equal.length()){
                break;
            }
        }
        while(true){
            if (fuhao.isEmpty()){
                break;

            }
            else{
                num1=number.pop();
                num2=number.pop();
                oper= fuhao.pop();
                number.push(compute(num1,num2,oper));
            }
        }
        return number.pop();
    }
}
class calculatorTest{
    public static void main(String[] args) {
       reform r=new reform("1+((2+3)*4)-5");
       ArrayList<String> s2=reform.start(r.equation);
       String[] s3=new String[s2.size()];
       for (int i=0;i<s2.size();i++){
           s3[i]=s2.get(i);
       }
        poLandNotation.calculatepolan(s3);
    }
}
//将后缀表达式进行计算
class poLandNotation{
    private String[] equation;

    public String[] getEquation() {
        return equation;
    }

    public poLandNotation(String string){
        this.equation=string.split(" ");
    }
    public static void calculatepolan(String[] lis){
        Stack<String> stack=new Stack<>();
        for (String item:lis){
            if (item.matches("\\d+")){
                stack.push(item);
            }else{
                int num1=Integer.parseInt(stack.pop());
                int num2=Integer.parseInt(stack.pop());
                int sum=0;
                switch (item){
                    case "+": sum=num2+num1;break;
                    case "-": sum=num2-num1;break;
                    case "*": sum=num2*num1;break;
                    case "/": sum=num2/num1;break;
                }
                stack.push(String.valueOf(sum));
            }
        }
        System.out.println(stack.pop());
    }
}
//将中缀转换为后缀
class reform{
     ArrayList<String> equation;
     public reform(String equation){
         ArrayList<String> lis=new ArrayList<>();
         String str;
         for (int i=0;i<equation.length();i++){
             if (equation.charAt(i)>57||equation.charAt(i)<48){
                 lis.add(equation.charAt(i)+"");
             }else{
                 int k=i;
                 str="";
                 while (equation.charAt(k)>=48&equation.charAt(k)<=57){
                     str+=equation.charAt(i);
                     k++;
                     if (k==equation.length()){
                         break;
                     }
                 }
                 lis.add(str);
             }
         }
         this.equation=lis;
     }
     public static ArrayList<String> start(ArrayList<String> equa){
         Stack<String> s1=new Stack<>();
         ArrayList<String> s2=new ArrayList<>();
         calculator cal=new calculator();

         for (String item:equa){
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
             }else if (item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else{
                while (s1.size()!=0&&cal.properity(item.charAt(0))<=cal.properity(s1.peek().charAt(0))){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
         }
         if (!s1.isEmpty()){
             s2.add(s1.pop());
         }
         return s2;
     }

}