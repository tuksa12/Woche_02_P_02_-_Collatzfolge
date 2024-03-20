package pgdp;

public class Polymorphie2 {
    interface X<S> {
        A m(S s);
    }
    static class A {
        void m(A a) {
            System.out.println("A.m(A)");
            a.m(this);
        }
        static B g(A a, B b) throws MyEx{
            System.out.println("A.g(A, B)");
            if(a == b)
                throw new MyEx();
            return (B) a;
        }
    }
    static class B extends A {
        void m(A a) {
            System.out.println("B.m(A)");
        }
        static B g(B b, A a) {
            System.out.println("B.g(B, A)");
            return b;
        }
    }
    static class C extends B implements X<B>{

        public void m(A a) {
            System.out.println("C.m(A)");
            m((B) a);
        }
        public A m(B b) {
            System.out.println("C.m(B)");
            return b;
        }
    }

    static class MyEx extends Exception{
        static void g(X<B> x){
            System.out.println("MyEx.g(X)");
            A a = x.m(new B());
            a.m(null);
        }
    }
    public static void main(String[] args) throws MyEx {
        A a = new A();
        A ab = new B();
        B b = new B();
        C c = new C();


//        A.g(a, b); // Aufruf 1
//        ab.m(b); // Aufruf 2
//        a.m(ab); // Aufruf 3
//        c.m(c.m(b)); // Aufruf 4
//        a.g(b,b); // Aufruf 5
//        MyEx.g((B bb) -> B.g(bb, a)); // Aufruf 6
//        B.g(b,b); // Aufruf 7

    }
}
