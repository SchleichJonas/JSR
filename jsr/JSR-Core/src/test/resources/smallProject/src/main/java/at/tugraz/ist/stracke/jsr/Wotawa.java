package at.tugraz.ist.stracke.jsr;

public class Wotawa
{
  public static float a;
  public static float c;
  public static float pi = 3.14159f;
  public static void wotawa(float d, int type){
    if(type ==0){
      float r = d / 2;
      a = r * r * pi;
      c = r * pi;
    } else{
      if(type == 1){
        a = d * d;
        c = 4 * d;
      }else{
        a = -1;
        c = -1;
      }
    }
  }
}