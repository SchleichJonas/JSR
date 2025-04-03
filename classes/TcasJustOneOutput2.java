

public class TcasJustOneOutput2
{
    private static final int OLEV = 600;
    private static final int MAXALTDIFF = 600;
    private static final int MINSEP = 300;
    private static final int NOZCROSS = 100;

    private static int Cur_Vertical_Sep = 0;
    private static int High_Confidence = 0;
    private static int Two_of_Three_Reports_Valid = 0;

    private static int Own_Tracked_Alt = 0;
    private static int Own_Tracked_Alt_Rate = 0;
    private static int Other_Tracked_Alt = 0;

    private static int Alt_Layer_Value = 0;
    private static int [] Positive_RA_Alt_Thresh = {0,0,0,0};

    private static int Up_Separation = 0;
    private static int Down_Separation = 0;

    private static int Other_RAC = 0;
    private static final int NO_INTENT = 0;
    private static final int DO_NOT_CLIMB = 1;
    private static final int DO_NOT_DESCEND = 2;

    private static int Other_Capability = 0;
    private static final int TCAS_TA = 1;
    private static final int OTHER = 2;

    private static int Climb_Inhibit = 0;

    private static final int UNRESOLVED = 0;
    private static final int UPWARD_RA = 1;
    private static final int DOWNWARD_RA = 2;

    private static void initialize()
    {
        Positive_RA_Alt_Thresh[0] = 400;
        Positive_RA_Alt_Thresh[1] = 500;
        Positive_RA_Alt_Thresh[2] = 640;
        Positive_RA_Alt_Thresh[3] = 740;
    }

    private static int ALIM()
    {
        return Positive_RA_Alt_Thresh[Alt_Layer_Value];
    }

    private static int Inhibit_Biased_Climb ()
    {
        return ((Climb_Inhibit!=0) ? Up_Separation + NOZCROSS : Up_Separation);
    }

    private static boolean Non_Crossing_Biased_Climb()
    {
        int upward_preferred = 0;
        int upward_crossing_situation = 0;
        boolean result = false;

        if(Inhibit_Biased_Climb() > Down_Separation)
            upward_preferred = 1;
        if (upward_preferred == 1)
        {
            result = !(Own_Below_Threat()) || ((Own_Below_Threat()) && (!(Down_Separation >= ALIM())));
        }
        else
        {
            result = Own_Above_Threat() && (Cur_Vertical_Sep >= MINSEP) && (Up_Separation >= ALIM());
        }
        return result;
    }

    private static boolean Non_Crossing_Biased_Descend()
    {
        int upward_preferred = 0;
        int upward_crossing_situation = 0;
        boolean result = false;

        if(Inhibit_Biased_Climb() > Down_Separation)
            upward_preferred = 1;
        if (upward_preferred == 1)
        {
            result = Own_Below_Threat() && (Cur_Vertical_Sep >= MINSEP) && (Down_Separation >= ALIM());
        }
        else
        {
            result = !(Own_Above_Threat()) || ((Own_Above_Threat()) && (Up_Separation >= ALIM()));
        }
        return result;
    }

    private static boolean Own_Below_Threat()
    {
        return (Own_Tracked_Alt < Other_Tracked_Alt);
    }

    private static boolean Own_Above_Threat()
    {
        return (Other_Tracked_Alt < Own_Tracked_Alt);
    }

    private static int alt_sep_test()
    {
        boolean enabled = false, tcas_equipped = false, intent_not_known = false;
        boolean need_upward_RA = false, need_downward_RA = false;
        int alt_sep = 0;

        enabled = (High_Confidence != 0) && (Own_Tracked_Alt_Rate <= OLEV) && (Cur_Vertical_Sep > MAXALTDIFF);
        tcas_equipped = (Other_Capability == TCAS_TA);
        intent_not_known = (Two_of_Three_Reports_Valid != 0) && (Other_RAC == NO_INTENT);

        alt_sep = UNRESOLVED;

        if (enabled && ((tcas_equipped && intent_not_known) || !tcas_equipped))
        {
            need_upward_RA = Non_Crossing_Biased_Climb() && Own_Below_Threat();
            need_downward_RA = Non_Crossing_Biased_Descend() && Own_Above_Threat();
            if (need_upward_RA && need_downward_RA)
                alt_sep = UNRESOLVED;
            else if (need_upward_RA)
                alt_sep = UPWARD_RA;
            else if (need_downward_RA)
                alt_sep = DOWNWARD_RA;
            else
                alt_sep = UNRESOLVED;
        }

        return alt_sep;
    }

    public static int testMe(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l)
    {
        initialize();
        Cur_Vertical_Sep = a;
        High_Confidence = b;
        Two_of_Three_Reports_Valid = c;
        Own_Tracked_Alt = d; //Integer.parseInt(args[3]);
        Own_Tracked_Alt_Rate = e; //Integer.parseInt(args[4]);
        Other_Tracked_Alt = f; //Integer.parseInt(args[5]);
        Alt_Layer_Value = g; //Integer.parseInt(args[6]);
        Up_Separation = h; //Integer.parseInt(args[7]);
        Down_Separation = i; //Integer.parseInt(args[8]);
        Other_RAC = j; //Integer.parseInt(args[9]);
        Other_Capability = k; //Integer.parseInt(args[10]);
        Climb_Inhibit = l; //Integer.parseInt(args[11]);
        return alt_sep_test();
        //System.exit(0);
    }
}