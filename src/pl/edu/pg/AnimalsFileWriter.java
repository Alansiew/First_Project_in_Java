package pl.edu.pg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AnimalsFileWriter {


    public void saveAnimal(Animal AnimalToSave)
    {
        BufferedWriter bw=null;
        FileWriter fw;
        try
        {
            fw = new FileWriter("animals.txt",true);
            bw = new BufferedWriter(fw);
            bw.write(String.valueOf(AnimalToSave.getID()));
            bw.newLine();
            bw.write(AnimalToSave.getName());
            bw.newLine();
            bw.write(AnimalToSave.getSex());
            bw.newLine();
            bw.write(AnimalToSave.getAge());
            bw.newLine();
            bw.write(AnimalToSave.getRace());
            bw.newLine();
            bw.write(AnimalToSave.getType());
            bw.newLine();
            bw.write(AnimalToSave.getOwner());
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