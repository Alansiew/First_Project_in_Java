package pl.edu.pg;

public class Dog extends Animal {


    public Dog(String Type, String Name, String Sex, int Age, String Owner, String Race) {
        super(Type, Name, Sex, Age, Owner, Race);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }
    protected void setAge(int Age){this.Age=Age;}
}