

public class GammqAltered {
    private static final int ITMAX = 100;
    private static final double EPS = 3.0e-7;
    private static final double FPMIN = 1.0e-30;

    public static double gamser, gammcf, gln;
    public static double result;

    private static double gammln(double xx) {

        double x,y,tmp,ser;

        double cof[]  = {76.18009172947146,-86.50532032941677,24.01409824083091,-1.231739572450155,0.1208650973866179e-2,-0.5395239384953e-5};

        int j;

        y=x=xx;
        tmp=x+5.5;
        tmp -= (x+0.5)*Math.log(tmp);
        ser=1.000000000190015;
        for (j=0;j<=5;j++) ser += cof[j]/++y;
        return -tmp+Math.log(2.5066282746310005*ser/x);
    }

    private static void gcf(double a, double x)
    {
        int i;
        double an,b,c,d,del,h;

        gln=gammln(a);
        b=x+1.0-a;
        c=1.0/FPMIN;
        d=1.0/b;
        h=d;
        for (i=1;i<=ITMAX;i++) {
            an = i*(i-a); //Error
            b += 2.0;
            d=an*d+b;
            if (Math.abs(d) < FPMIN) d=FPMIN;
            c=b+an/c;
            if (Math.abs(c) < FPMIN) c=FPMIN;
            d=1.0/d;
            del=d*c;
            h *= del;
            if (Math.abs(del-1.0) < EPS) break;
        }
        if (i > ITMAX) throw new RuntimeException ("a too large, ITMAX too small in gcf");
        gammcf=Math.exp(-x+a*Math.log(x)-gln)*h;
    }

    private static void gser(double a, double x) {

        int n;
        double sum,del,ap;

        gln=gammln(a);

        if (x <= 0.0) {
            if (x < 0.0) throw new RuntimeException ("x less than 0 in routine gser");
            gamser=0.0;
            return;
        }
        else {
            ap=a;
            del=sum=1.0/a;
            for (n=1;n<=ITMAX;n++) {
                ++ap;
                del *= x/ap;
                sum += del;
                if (Math.abs(del) < Math.abs(sum)*EPS) {
                    gamser=sum*Math.exp(-x+a*Math.log(x)-gln);
                    return;
                }
            }
            throw new RuntimeException ("a too large, ITMAX too small in routine gser");
        }
    }

    public static void exe(double a, double x) {
        gamser = 0;
        gammcf = 0;
        gln = 0;
        result = 0;
        if (x < 0.0 || a <= 0.0) throw new RuntimeException("Invalid arguments in routine gammq");
        if (x < (a+1.0)) {
            gser(a,x);
            result = 1-gamser;
        }
        else {
            gcf(a,x);
            result = gammcf;
        }
    }
}