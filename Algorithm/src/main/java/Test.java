/**
 * @author : dev
 * @version :
 * @Date :  11/29/21 2:07 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("测试");
        new HelloB();
    }


    static class HelloA {
        public HelloA() {
            System.out.println("HelloA");
        }

        static {
            System.out.println("static A ： 静态代码块");
        }

        {
            System.out.println(" I am HelloA ： 实例初始化块");
        }
    }


    static class HelloB extends HelloA {
        public HelloB() {
            System.out.println("HelloB");
        }

        static {
            System.out.println("static B");
        }

        {
            System.out.println(" I am HelloB");
        }
    }


}
