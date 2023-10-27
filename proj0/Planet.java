public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    public Planet(){}
    public Planet(Planet p) {
        this.xxPos=p.xxPos;
        this.yyPos=p.yyPos;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
        this.mass=p.mass;
        this.imgFileName=p.imgFileName;
    }
    public Planet(double xP, double yP, double xV,double yV, double m, String img){
        this.xxPos=xP;
        this.yyPos=yP;
        this.xxVel=xV;
        this.yyVel=yV;
        this.mass=m;
        this.imgFileName=img;
    }

    public double calcDistance(Planet rocinante){
        double distance=Math.sqrt((this.xxPos-rocinante.xxPos)*(this.xxPos-rocinante.xxPos)+(this.yyPos-rocinante.yyPos)*(this.yyPos-rocinante.yyPos));
        return distance;
    }
    public double calcForceExertedBy(Planet rocinante){
        double G=6.67e-11;
        double dis=calcDistance(rocinante);
        double force=G*this.mass*rocinante.mass/(dis*dis);
        return force;
    }
    public double calcForceExertedByX(Planet rocinante){
        double force=calcForceExertedBy(rocinante);
        double dis=calcDistance(rocinante);
        double forceX=force*(rocinante.xxPos-this.xxPos)/dis;
        return forceX;
    }
    public double calcForceExertedByY(Planet rocinante){
        double force=calcForceExertedBy(rocinante);
        double dis=calcDistance(rocinante);
        double forceY=force*(rocinante.yyPos-this.yyPos)/dis;
        return forceY;
    }
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double netForceX=0.0;
        for(Planet p:allPlanets){
            if(!this.equals(p))
                netForceX+=calcForceExertedByX(p);
        }
        return netForceX;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double netForceY=0.0;
        for(Planet p:allPlanets){
            if(!this.equals(p))
                netForceY+=calcForceExertedByY(p);
        }
        return netForceY;
    }
    public void update(double dt, double fX, double fY){
        double ax=fX/this.mass;
        double ay=fY/this.mass;

        this.xxVel+=dt*ax;
        this.yyVel+=dt*ay;

        this.xxPos+=this.xxVel*dt;
        this.yyPos+=this.yyVel*dt;
    }
    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
    }
}
