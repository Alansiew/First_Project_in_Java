package pl.edu.pg;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OwnerFileWriter {


        public void saveOwner(Owner OwnerToSave)
        {
            BufferedWriter bw=null;
            FileWriter fw;
            try
            {
                fw = new FileWriter("owner.txt",true);
                bw = new BufferedWriter(fw);
                bw.write(String.valueOf(OwnerToSave.getId()));
                bw.newLine();
                bw.write(OwnerToSave.getName());
                bw.newLine();
                bw.write(OwnerToSave.getLastName());
                bw.newLine();
                bw.write(OwnerToSave.getAge());
                bw.newLine();
                bw.write(OwnerToSave.getSex());
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


