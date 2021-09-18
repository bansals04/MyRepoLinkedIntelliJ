package Test.SingletonClass;

public class King {

    private static final King king = new King();


     static String nameField = "Hello";
            String addressField = "Ajnara";


    public static King method1(String s){

        System.out.println(nameField);

        System.out.println(s);
        return king;
    }

    //We cannot create constructor os this class, from outside this class. Because when creating class object we actually called the Constructor.
    //which is created as private here.
    //So that is why this is a Singleton class, who ONLY can have single object.
    private King(){
        System.out.println("Hello I am King class's private Constructor");
    }
}
