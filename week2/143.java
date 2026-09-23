public static void main(String[] args) {
    StdDraw.setCanvasSize(800, 800);
    StdDraw.setXscale(0, 10000); 
    StdDraw.setYscale(0, 10);    
    StdDraw.setPenRadius(0.01);

    double maxN = 10000;
    double maxTime = 10.0;

    for (int n = 250; true; n += n) {
        double time = timeTrial(n);
        StdOut.printf("%7d %7.1f\n", n, time);
        
        if (n > maxN || time > maxTime) {
            maxN = Math.max(maxN, n * 2);
            maxTime = Math.max(maxTime, time * 2);
            StdDraw.setXscale(0, maxN);
            StdDraw.setYscale(0, maxTime);
            StdDraw.clear();
        }
        
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.point(n, time);
        
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(Math.log(n), Math.log(time > 0 ? time : 0.001));
    }
}