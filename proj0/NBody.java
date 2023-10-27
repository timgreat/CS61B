import java.io.*;

public class NBody {

    public static void main(String[] args){
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double radius=readRadius(filename);
        Planet[] planets=readPlanets(filename);

        StdDraw.enableDoubleBuffering();
        int time=0;
        int i=0;
        while(time<T){
            double[] xForces=new double[planets.length];
            double[] yForces=new double[planets.length];
            for(i=0;i<planets.length;i++){
                xForces[i]=planets[i].calcNetForceExertedByX(planets);
                yForces[i]=planets[i].calcNetForceExertedByY(planets);
            }
            for(i=0;i< planets.length;i++){
                planets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.setScale(-radius, radius);
            /* Clears the drawing window. */
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            StdDraw.pause(10);
            for(i=0;i<planets.length;i++){
                planets[i].draw();
            }
            StdDraw.show();
            time+=dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }



    }
    public static double readRadius(String file){
        In in =new In(file);
        in.readInt();
        double radius=in.readDouble();
        return radius;

    }

    public  static Planet[] readPlanets(String file){
        In in=new In(file);
        int n=in.readInt();
        in.readDouble();
        Planet[] planets=new Planet[n];
        for(int i=0;i<n;i++){
            Planet planet=new Planet();
            planet.xxPos=in.readDouble();
            planet.yyPos=in.readDouble();
            planet.xxVel=in.readDouble();
            planet.yyVel=in.readDouble();
            planet.mass=in.readDouble();
            planet.imgFileName=in.readString();
            planets[i]=planet;
        }
        return planets;
    }
}
