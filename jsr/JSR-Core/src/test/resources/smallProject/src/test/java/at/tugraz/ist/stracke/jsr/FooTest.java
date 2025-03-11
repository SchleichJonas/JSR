package at.tugraz.ist.stracke.jsr;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import java.lang.Math;

public class FooTest {

    public FooTest() {
    }

    @Test
    public void foo() {
        Foo foo = new Foo();
        Assert.assertEquals(true, Math.abs(foo.calc(3,"square") - (3*3)) < 1e-9);
    }
    @Test
    public void foo2() {
        Foo foo = new Foo();
        Assert.assertEquals(true, Math.abs(foo.calc(3,"cube") - (3*3*3)) < 1e-9);
    }
}
