package Test.SingletonClass;

public class Queen {

    public static final Queen queen;

    //If we make private constructor, then we cannot make object of this class from outside any class.
    //We cannot create constructor os this class, from outside this class. Because when creating class object we actually called the Constructor.
    //which is created as private here.
    //So that is why this is a Singleton class, who ONLY can have single object.
    private Queen(){

    }

    static {
        queen = new Queen();
    }
}
