package at.tugraz.ist.stracke.jsr;

public class MiddleJustOneOutput {
    public int findMiddle(int a, int b,
                          int c){
        if((a<b && b<c)|| (c<b && b>a)){//if((a<b && b<c)|| (c<b && b<a)){//Error
            return b;
        }
        else if((a<c && c<b)||(b<c
                && c<a )){
            return c;
        }
        else if((b < a && a <c) ||
                (c<a && a<b) ){
            return a;
        }
        else if (b==c){
            return a;
        }
        else if (b==a){
            return c;
        }
        else {
            return b;
        }
    }
}