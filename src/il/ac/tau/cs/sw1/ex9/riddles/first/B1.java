package il.ac.tau.cs.sw1.ex9.riddles.first;

public class B1 extends A1 {
    private C1 occur;

    public B1(){
        this.occur = new C1();
    }

    protected String foo(){
        String change = this.occur.foo();
        int n = change.length() -1;
        return change.substring(0, n-1);
    }
}
