



class Calc
{
    public static int add(int x,int y){
        return x+y;
    }
    public static int sub(int x,int y){
        return x-y;
    }
    public static int mul(int x,int y){
        return x*y;
    }
    public static int div(int x,int y){
        return x/y;
    }
}

public class Main {
    public static void main(String[] args){
        int x=5,y=6,z;
        z=Calc.add(x,y);
        System.out.println("Сумма "+x+" и "+y+" равна "+z);
    }
}

