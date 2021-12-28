package pl.edu.pg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TurtlesFileWriter {
    public void saveTurtle(Turtle TurtleToSave)
    {
        BufferedWriter bw=null;
        FileWriter fw;
        try
        {
            fw = new FileWriter("turtles.txt",true);
            bw = new BufferedWriter(fw);
            bw.write(String.valueOf(TurtleToSave.getID()));
            bw.newLine();
            bw.write(TurtleToSave.getName());
            bw.newLine();
            bw.write(TurtleToSave.getAge());
            bw.newLine();
            bw.write(TurtleToSave.getSex());
            bw.newLine();
            bw.write(TurtleToSave.getType());
            bw.newLine();
            bw.write(TurtleToSave.getOwner());
            bw.newLine();



        }
        catch (IOException e)
        {
            System.out.println("Error when try to save owner.txt file");
            e.printStackTrace();
        }
        finally
        {
            if (bw != null)
            {
                try {
                    bw.close();
                } catch (IOException e)
                {
                    System.out.println("Error when try to close owner.txt file");
                    e.printStackTrace();
                }
            }
        }
    }
}
