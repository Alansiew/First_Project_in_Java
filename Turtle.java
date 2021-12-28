package pl.edu.pg;

import java.util.ArrayList;
import java.util.Arrays;

public class Turtle extends Animal{

    private long TurtleCount=0;
    private String turtle_status;


    public Turtle(String Type, String Name, String Sex, int Age,String Race, String Owner) {
        super(Type, Name, Sex, Age,Race, Owner);
        this.TurtleCount=++TurtleCount;    }
    public enum Status
    {
ACTIVE("Active"),INACTIVE("In the shell");
        private String active;

        Status(String active) {
            this.active=active;
        }


    }
    private Status status;
    ///////////////   getters i setters   /////////////
    public long getTurtleCount(){ return TurtleCount;}
    public void setTurtleCount(long TurtleCount){this.TurtleCount=TurtleCount;}
    public String getName()
    {
        return Name;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
