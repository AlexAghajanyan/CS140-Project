import java.util.Arrays;

public class Spring {
    
    private double k;

    // constructor with no parameter
    Spring() {
        this.k = 1;
    }

    // constructor with a single parameter
    Spring(Double k) {
        this.k = k;
    }

    // Getter
    public Double getStiffness() {
        return k;
    }

    // Setter
    private void setStiffness(Double k) {
        this.k = k;
    }

    private Double[] get_coordinates(double e, double t, double dt) {
        // Calculating the apmlitude.
        double ampl = Math.sqrt((2 * e) / this.k);

        // Calculate maximum velocity.
        double max_v = ampl*Math.sqrt(this.k);

        // Calculating oscillation period.
        double period = Math.PI*2*ampl / max_v;

        // Calculating the angular velocity.
        double omega = 2*Math.PI / period;

        double timestep = t / dt; 
        Double[] x_coordinates = new Double[(int)timestep]; 

        // Computing the coordinates per each dt starting from t = 0.
        for(double i = 0; i <= t; i += dt) {
            int count = 0;
            System.out.println(Math.cos(omega*i));
            x_coordinates[count] = ampl * Math.cos(omega*i);
            count++;
        }

        return x_coordinates;
    }

    public Double[] move(double t, double dt, double x0, double v0) {

        // Calculating energy based on the given position and velocity.
        double e = (Math.pow(x0, 2) * this.k)/2 + Math.pow(v0, 2)/2;   
        System.out.println(e);

        return get_coordinates(e, t, dt);
    }

    public Double[] move(double t, double dt, double x0) {

        // Calculating energy based on the given position and velocity.
        double e = (Math.pow(x0, 2) / 2);   
        System.out.println(e);

        return get_coordinates(e, t, dt);
    }

    public Double[] move(double t0, double tl, double dt, double x0, double v0) {

        // Calculating energy based on the given position and velocity.
        double e = (Math.pow(x0, 2) * this.k)/2 + Math.pow(v0, 2)/2;  
        double t = tl - t0;
        return get_coordinates(e, t, dt);
    }

    public Double[] move(double t0, double tl, double dt, double x0, double v0, double m) {

        // Calculating energy based on the given position and velocity.
        double e = (Math.pow(x0, 2) * this.k)/2 + Math.pow(v0, 2)*m/2;  
        double t = tl - t0;
        return get_coordinates(e, t, dt);
    }

    public Spring inSeries(Spring that) {
        double k = this.getStiffness() + that.getStiffness();

        return new Spring(k);
    }

    public Spring inParallel(Spring that) {
        double k = 1 / (1/this.getStiffness() + 1/that.getStiffness());

        return new Spring(k);
    }

    public static void main(String[] args) {
        Spring spring = new Spring(1.5);
        spring.move(1.0, 0.2, 1.0);
        spring.move(1.0, 0.2, 1.0, 2.0);        
    }
}