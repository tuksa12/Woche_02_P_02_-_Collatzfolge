package pgdp;
public class Polymorphie {
    static class A {
        public void f() {
            System.out.println("A.f()");
        }

        public void f(A a) {
            System.out.println("A.f(A)");
            a.g();
        }

        public void f(B b) {
            System.out.println("A.f(B)");
            b.g();
        }

        public static void g() {
            System.out.println("A.g()");

}
        public void h(A a, B b) {
            System.out.println("A.h(A, B)");
        }
    }
    static class B extends A {
        public void f(A a) {
            System.out.println("B.f(A)");
            a.f();
        }

        public static void g() {
            System.out.println("B.g()");
        }

        public void h(B b, A a) {
            System.out.println("A.h(B, A)");
        }
    }

    static class C extends B {
        public void f(B b) {
            System.out.println("C.f(B)");
            ((C) b).f((C) b);
        }

        public void f(C c) {
            System.out.println("C.f(C)");
        c.g();
        }

        public void h() {
            System.out.println("C.h()");
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        A c = new C();
//        a.f(a); // Aufruf 1
//        b.f(a); // Aufruf 2
//        b.f(b); // Aufruf 3
        c.g(); // Aufruf 4
//        c.f(b); // Aufruf 5
//        c.h(); // Aufruf 6
//        ((C) c).f(); // Aufruf 7
//        c.f(new C()); // Aufruf 8
//        a.f(null); // Aufruf 9
//        b.h(b, b); // Aufruf 10
    }

}
