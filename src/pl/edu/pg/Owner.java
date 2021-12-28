package pl.edu.pg;

public class Owner extends Eukaryote implements Saveable
{
    private static int OwnerCount=0;
    private int id;
    private String LastName;
    private String Animal_owner;
    public Owner(String Name, String LastName, String Sex, int Age,String Animal_owner)
    {

        super(Name, Sex, Age);
        this.LastName=LastName;
        this.Animal_owner=Animal_owner;
        this.id= ++OwnerCount;
    }

    public void info()
    {
        printBasicInfo("Owner");
        System.out.println(" Last name:      "+this.LastName);
        System.out.println(" ID:             "+this.id);
        System.out.println(" His animals "+ this.Animal_owner+"\n");
    }
    public void name_info()
    {
        nameInfo("Owner");
        System.out.println(" ID:             "+this.id);
        System.out.println(" His animals "+ this.Animal_owner);
    }

    public int getId()
    {
        return id;
    }
    @Override
    public int getAge() {
        return super.getAge();
    }
    protected void setAge(int Age){this.Age=Age;}
    public String getLastName() {
        return LastName;
    }

    @Override
    public String getFileNameToSave() {
        return "owner.txt";
    }

    @Override
    public String getDataToSave() {
        String data="";
        data+=  this.id+"\n";
        data+=    this.Name+"\n";
        data+=    this.LastName+"\n";
        data+=     this.Age+"\n";
        data+=     this.Sex+"\n";

return data;
    }
    public String getAnimal_owner(){
        return Animal_owner;
    }
    public void setAnimal_owner(String Animal_owner) {
        this.Animal_owner = Animal_owner+" ";
    }
    public int getOwnerCount(){ return OwnerCount;}
    public void setOwnerCount(int OwnerCount){this.OwnerCount=OwnerCount;}
}

