

public class Fisher2
{
    public static double result;
    public static double p;
    public static int a;
    public static int b;

    public static void exe(int m, int n, double x)
    {
        result = 0;
        p = 0;
        a = 0;
        b = 0;
        int i, j;
        double w, y, z, zk, d;

        a = 2*(m/2)-m+2;
        b = 2*(n/2)-n+2;
        w = (x*m)/n;
        z = 1.0/(1.0+w);

        if(a == 1)
        {
            if(b == 1)
            {
                p = Math.sqrt(w);
                y = 0.3183098862;
                d = y*z/p;
                p = 2.0*y*Math.atan(p);
            }
            else
            {
                p = Math.sqrt(w*z);
                d = 0.5*p*z/w;
            }
        }
        else if(b == 1)
        {
            p = Math.sqrt(z);
            d = 0.5*z*p;
            p = 1.0-p;
        }
        else
        {
            d = z*z;
            p = w*z;
        }

        y = 2.0*w/z;

        if(a == 1)
            for(j = b+2; j <= n; j += 2)
            {
                d *= (1.0+1.0/(j-2))*z;
                p += d*y/(j-1);
            }
        else
        {
            zk = Math.pow(z, (double)((n-1)/2));
            d *= (zk*n)/b;
            p = p*zk+w*z*(zk-1.0)/(z-1.0);
        }

        y = w*z;
        z = 2.0/z;
        b = n-2;
        for(i = a+2; i <= m; i += 2)
        {
            j = i+b;
            d *= (y*j)/(i-2);
            p -= z*d/j;
        }

        if(p<0.0)
            result = 0.0;
        else if(p>1.0)
            result = 1.0;
        else
            result = p;
    }
}