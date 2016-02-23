import processing.core.PApplet;

/**
 * Created by sam on 2/22/16.
 */


public class Wave {



    private int xspacing = 16;   // How far apart should each horizontal location be spaced
    private int w;              // Width of entire wave

    private float theta = 0.0f;  // Start angle at 0
    private float amplitude = 75.0f;  // Height of wave
    private float period = 500.0f;  // How many pixels before the wave repeats
    private float dx;  // Value for incrementing X, a function of period and xspacing
    private float[] yvalues;  // Using an array to store height values for the wavefloat theta = 0.0;  // Start angle at 0
    PApplet parent;

    public Wave(int xspacing, int w, float theta, float amplitude, float period, float dx, float[] yvalues, PApplet parent) {
        this.xspacing = xspacing;
        this.w = w;
        this.theta = theta;
        this.amplitude = amplitude;
        this.period = period;
        this.dx = dx;
        this.yvalues = yvalues;
        this.parent = parent;
    }

    void drawWave() {

        calcWave();
        renderWave();

    }


    void calcWave() {
        // Increment theta (try different values for 'angular velocity' here
        theta += 0.02;

        // For every x value, calculate a y value with sine function
        float x = theta;
        for (int i = 0; i < yvalues.length; i++) {
            yvalues[i] = parent.sin(x) * amplitude;
            x += dx;
        }
    }

    void renderWave() {
        parent.noStroke();
        parent.fill(255);
        // A simple way to draw the wave with an ellipse at each location
        for (int x = 0; x < yvalues.length; x++) {
            parent.ellipse(x * xspacing, parent.height / 2 + yvalues[x], 16, 16);
        }
    }

}
