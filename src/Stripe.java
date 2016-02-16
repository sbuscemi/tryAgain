import processing.core.PApplet;

/**
 * Created by sam on 2/13/16.
 */
public class Stripe {
    float x;       // horizontal location of stripe
    float speed;   // speed of stripe
    float w;       // width of stripe
    boolean mouse; // state of stripe (mouse is over or not?)
    PApplet parent; // The parent PApplet that we will render ourselves onto

    Stripe(PApplet p) {
        parent = p;
        x = 0;              // All stripes start at 0
        speed = (parent.random(1)/2);  // All stripes have a random positive speed
        w = parent.random(10,400);
        mouse = false;
    }

    // Draw stripe
    void display() {
        parent.smooth();
        parent.noStroke();
        if(parent.random(100)>30) {
            parent.fill(parent.random(255), parent.random(255), parent.random(255));
        }
        parent.beginShape();
        parent.vertex(50+x, 15+x);
        parent.bezierVertex(50+x, -5+x, 90+x, 5+x, 50+x, 40+x);
        parent.vertex(50+x, 15+x);
        parent.bezierVertex(50+x, -5+x, 10+x, 5+x, 50+x, 40+x);
        parent.endShape();
    }

    // Move stripe
    void move() {
        x += speed;
        if (x > parent.width+20) x = -20;
    }
}
