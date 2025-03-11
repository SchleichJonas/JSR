package at.tugraz.ist.stracke.jsr;

//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
import java.lang.Math;

public class WotawaTest {

  public WotawaTest() {
  }

  @Test
  public void wotawa1() {
    Wotawa.wotawa(1,0);
    Assert.assertEquals(0.7853975f, Wotawa.a, 0.0001);
  }

  @Test
  public void wotawa2() {
    Wotawa.wotawa(1,1);
    Assert.assertEquals(1f, Wotawa.a, 0.0001);
  }

  @Test
  public void wotawa3() {
    Wotawa.wotawa(1,2);
    Assert.assertEquals(-1f, Wotawa.a, 0.0001);
  }

  @Test
  public void wotawa4() {
    Wotawa.wotawa(0,0);
    Assert.assertEquals(0f, Wotawa.a, 0.0001);
  }
  @Test
  public void wotawa5() {
    Wotawa.wotawa(0,1);
    Assert.assertEquals(0f, Wotawa.a, 0.0001);
  }

  @Test
  public void wotawa6() {
    Wotawa.wotawa(0,2);
    Assert.assertEquals(true, Math.abs(Wotawa.a + 1) < 1e-9);
  }

  @Test
  public void wotawa7() {
    Wotawa.wotawa(1,0);
    Assert.assertEquals(3.14159f, Wotawa.c, 0.0001);
  }

  @Test
  public void wotawa8() {
    Wotawa.wotawa(1,1);
    Assert.assertEquals(4f, Wotawa.c, 0.0001);
  }

  @Test
  public void wotawa9() {
    Wotawa.wotawa(1,2);
    Assert.assertEquals(-1f, Wotawa.c, 0.0001);
  }

  @Test
  public void wotawa10() {
    Wotawa.wotawa(0,0);
    Assert.assertEquals(0f, Wotawa.c, 0.0001);
  }
  @Test
  public void wotawa11() {
    Wotawa.wotawa(0,1);
    Assert.assertEquals(0f, Wotawa.c, 0.0001);
  }

  @Test
  public void wotawa12() {
    Wotawa.wotawa(0,2);
    Assert.assertEquals(-1f, Wotawa.c, 0.0001);
  }

}
