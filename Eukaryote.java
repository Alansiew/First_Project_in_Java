package pl.edu.pg;

public abstract class Eukaryote
{


    protected String Name;
    protected String Sex;
    protected int Age;

    public Eukaryote(String Name, String Sex, int Age)
    {
        this.Name=Name;
        this.Sex=Sex;
        this.Age=Age;
    }
    protected void printBasicInfo(String EukaryoteType)
    {

        System.out.println(" Name:          "+this.Name);
        System.out.println(" Sex:           "+this.Sex);
        System.out.println(" Age:           "+this.Age);
    }
    protected void nameInfo(String EukaryoteType)
    {
        System.out.println(" Name:          "+this.Name);
    }



    ///////////////   getters and setters   /////////////

    public  String getName()
    {
        return Name;
    }

    public String getSex()
    {
        return Sex;
    }

    public int getAge()
    {
        return Age;
    }
}
