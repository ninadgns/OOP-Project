interface Hehe {
    void f();
}

class A implements Hehe {
    public void f() {
        System.out.println("Ahehe");
    }

    public void g() {
        System.out.println("Ahehe");
    }
}

class B implements Hehe {
    public void f() {
        System.out.println("Bhehe");
    }
}

class ConditionalHehe implements Hehe {
    private Hehe delegate;

    public ConditionalHehe(boolean condition) {
        if (condition) {
            delegate = new A();
        } else {
            delegate = new B();
        }
    }

    @Override
    public void f() {
        delegate.f();
    }
}

public class amiKeuna {
    public static void main(String[] args) {
        Hehe hehe = new ConditionalHehe(true); // Or false for B
        hehe.f();
//        hehe.g
    }
}
