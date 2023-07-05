package il.ac.tau.cs.sw1.ex9.riddles.second;

public class B2 extends A2{
    private int n;
    public B2(){
        this.n = 0;
    }
    public B2 getA(int n){
        this.n = n;
        return this;
    }
    @Override
    public String foo(String str){
        String change = str;
        int len = change.length();
        return change.substring(0, (len / (this.n + 1)));
    }
}
