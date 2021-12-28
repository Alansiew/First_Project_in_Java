package pl.edu.pg;

public class Animal extends Eukaryote
{
    private static long AnimalCount=0;
    private String Type;

    private String Owner;
    private String Race;

    private long id;


    public Animal(String Type,String Name, String Sex, int Age,String Race,String Owner) {
        super(Name, Sex, Age);
        this.Owner=Owner;
        this.Race=Race;
        this.Type =Type;
        this.id=++AnimalCount;
    }




    public void info()
    {
        printBasicInfo("Animal");

        System.out.println(" Race:          "+this.Race);
        System.out.println(" Type:          "+ this.Type);
        System.out.println(" Owner:         "+this.Owner);
        System.out.println(" ID:            "+this.id+"\n");
    }
    public void name_info()
    {
        nameInfo("Animal");
        System.out.println(" Type             "+this.Type);
        System.out.println(" ID:             "+this.id);

    }
    //-----------------------setery i getery-----------------------
    private int x1,y1;

    public  int getX1() {
        return x1;
    }


    public int getY1() {
        return y1;
    }

    protected void setX1(int x1) {
        this.x1 = x1;
    }

    protected void setY1(int y1) {
        this.y1 = y1;
    }

    @Override
    public int getAge() {
        return super.getAge();
    }
    protected void setAge(int Age){this.Age=Age;}

    public String position() {
        return "[" + x1 +" , "  + y1 + "]";
    }

    public  String getRace()
    {
        return Race;
    }
    public String getType()
    {
        return Type;
    }
    public long getID(){return id;}
    public void setID(long id){this.id=id;}
    public String getOwner(){return Owner;}
    protected void setOwner(String Owner){this.Owner=Owner;}
    public long getAnimalCount(){ return AnimalCount;}
    public void setAnimalCount(long AnimalCount){this.AnimalCount=AnimalCount;}
    }

