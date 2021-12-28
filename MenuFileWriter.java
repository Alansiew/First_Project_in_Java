package pl.edu.pg;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import pl.edu.pg.Owner;
import pl.edu.pg.Animal;
import pl.edu.pg.Eukaryote;
import java.util.List;

public class MenuFileWriter {

public void save(Saveable objectToSave){
    save(List.of(objectToSave));
}
public void save (List<Saveable>objectsToSave){
    BufferedWriter bw=null;
    try{
        FileWriter fw =new FileWriter(objectsToSave.get(0).getFileNameToSave());
        bw = new BufferedWriter(fw);
        for (Saveable objectToSave : objectsToSave)
        {
            bw.write(objectToSave.getDataToSave());
        }
    }catch (IOException e){
        System.out.println("Error when try to save + "+ objectsToSave.get(0).getFileNameToSave());
        e.printStackTrace();
    }
    finally {
        if (bw != null)
        {
            try{
                bw.close();

            }
            catch (IOException e)
            {
                System.out.println("Error when try to close file "+ objectsToSave.get(0).getFileNameToSave());
                e.printStackTrace();
            }
        }
    }
}


}
