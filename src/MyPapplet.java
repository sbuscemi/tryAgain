import processing.core.*;

/**
 * Created by sam on 2/13/16.
 */
public class MyPapplet extends PApplet {

    public static void main(String... args){
        String[] pArgs = {"MyPapplet "};
        MyPapplet mp = new MyPapplet ();
        PApplet.runSketch(pArgs, mp);
    }

    Stripe[] stripes = new Stripe[50];
    PFont f;

    public void settings() {
        size(400, 400);

    }

    public void setup() {
        // Initialize all "stripes"
        frameRate(20);
        f = createFont("Arial",16,true);
        for (int i = 0; i < stripes.length; i++) {
            stripes[i] = new Stripe(this);
        }
    }

    public void draw() {
        background(100);

        textFont(f,16);                  // STEP 3 Specify font to be used
        fill(0);                         // STEP 4 Specify font color
        text("Happy Valentines Day, Blue! I love you!",10,250);
        // Move and display all "stripes"
        for (int i = 0; i < stripes.length; i++) {
            stripes[i].move();
            stripes[i].display();
        }
    }
}