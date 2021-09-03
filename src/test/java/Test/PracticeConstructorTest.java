package Test;

public class PracticeConstructorTest {





        int test_a, test_b;
        PracticeConstructorTest(int a, int b)
        {
            test_a = a;    //this. is optional
            test_b = b;
        }
        public static void main (String args[])
        {
            PracticeConstructorTest test = new PracticeConstructorTest(1,7);
            System.out.println(test.test_a+" "+test.test_b);


        }
    }
