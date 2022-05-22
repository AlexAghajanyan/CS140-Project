package src;
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
    @SuppressWarnings("unused")
	private void setStiffness(Double k) {
        this.k = k;
    }

    private Double[] get_coordinates(double t0, double t1, double dt, double x0, double v0, double m) {

        // Calculating the angular velocity.
        double omega = Math.sqrt(this.k / m);

        double timestep = (t1 - t0) / dt; 
        Double[] x_coordinates = new Double[(int)timestep]; 

        // Computing the coordinates per each dt starting from t = t0.
        for(double i = t0; i <= t1; i += dt) {
            int count = 0;

            // Obtaining coordinates of object-spring system.
            x_coordinates[count] = x0 * Math.cos(omega*i) + (v0/omega) * Math.sin(omega*i);
            count++;
        }

        return x_coordinates;
    }

    public Double[] move(double t, double dt, double x0, double v0) {
        return get_coordinates(0, t, dt, x0, v0, 1);
    }

    public Double[] move(double t, double dt, double x0) {
        return get_coordinates(0, t, dt, x0, 0, 1);
    }

    public Double[] move(double t0, double t1, double dt, double x0, double v0) {
        return get_coordinates(t0, t1, dt, x0, v0, 1);
    }

    public Double[] move(double t0, double t1, double dt, double x0, double v0, double m) {
        return get_coordinates(t0, t1, dt, x0, v0, m);
    }

    public Spring inSeries(Spring that) {
        double k = this.getStiffness() + that.getStiffness();

        return new Spring(k);
    }

    public Spring inParallel(Spring that) {
        double k = (this.k * that.k) / (this.k + that.k);

        return new Spring(k);
    }
}
