package pl.edu.pg;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Menu {
    // Lists of the animals nad the owners
    List<Owner> owners = new ArrayList<>();
    List<Owner> owners_to_take = new ArrayList<>();
    List<Animal>animals_to_add=new ArrayList<>();
    List<Animal> animals = new ArrayList<>();
    List<Turtle> turtles = new ArrayList<>();
    List<Dog> dogs = new ArrayList<>();

    private String turtle_status;
    private String Type;
    private String turtle_race;
    private String dog_owner;
    private String cat_owner;
    private String turtle_owner;
    private String animal_owner;


    public void menu() throws IOException {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            boolean c = false;

// Main menu, looping until type 4
            while (!c) {
                System.out.println("Welcome to the menu, make your choice\n");
                System.out.println("1. Owner options");
                System.out.println("2. Animals options");
                System.out.println("3. Other options");
                System.out.println("4. Add One Year");
                System.out.println("5. End program");
                String choice = reader.readLine();
                switch (choice) {
                    case "5": {
                        c = true;
                        break;
                    }

                    case "1":
                        System.out.println("1. Add new owner");
                        System.out.println("2. Delete Owner");
                        System.out.println("3. Owner info");
                        System.out.println("4. Owners list");
                        System.out.println("5. Add animal to owner");   // Possibility to connect animal with owner only if owner has no any animals
                        System.out.println("6. Return to main menu");
                        String owner_choice = reader.readLine();


                        switch (owner_choice) { //should use setters here
                            case "1": {
                                System.out.println("Enter name");
                                String owner_name = reader.readLine();
                                System.out.println("Enter last name");
                                String owner_last_name = reader.readLine();
                                System.out.println("Enter sex owner, male or female");
                                String owner_sex = reader.readLine();
                                while (!owner_sex.equals("Male")||!owner_sex.equals("male")||!owner_sex.equals("Female")||!owner_sex.equals("female"))
                                {
                                    if(owner_sex.equals("Male")||owner_sex.equals("male")||owner_sex.equals("Female")||owner_sex.equals("female")){
                                        break;
                                    }
                                    else {
                                        System.out.println("You have to put male or female");
                                        owner_sex = reader.readLine();
                                    }
                                }
                                System.out.println("Enter age");
                                Scanner input = new Scanner(System.in);

                                int owner_age = input.nextInt();

                                Owner owner = new Owner(owner_name, owner_last_name, owner_sex, owner_age,animal_owner); // tworzy nowego wlasciciela
                                owners.add(owner);          // add owner to list
                                owners_to_take.add(owner);
                                owner.setAge(owner_age);
                                OwnerFileWriter ownerFileWriter = new OwnerFileWriter();
                                ownerFileWriter.saveOwner(owner); // saving owner

                                break;
                            }
                            case "2": {
                                System.out.println("Enter ID owner you want to delete ");
                                for (Owner Owner : owners) {
                                    Owner.name_info();
                                }


                                Scanner sc6 = new Scanner(System.in);
                                int id_3 = sc6.nextInt()-1; // is -1 because real index is always a number -1 smaller


                                for(Animal animal :animals) {

                                     if (animal.getOwner()!=null&&animal.getOwner().equals(owners.get(id_3).getName()))
                                    {

                                        owners.get(id_3).setAnimal_owner(null); // set null for animal keeper
                                        animal.setOwner(null);                  // set null for value wich say who is the animal keeper

                                    }

                                }
                                owners.get(id_3).setOwnerCount(owners.get(id_3).getOwnerCount()-1); // set correct ID after removing the owner
                                owners.removeIf(Owner -> Owner.getId() == (id_3)+1);

                                break;
                            }
                            case "3": {
                                System.out.println("Enter owner ID you want to check");
                                for (Owner Owner : owners) {
                                    Owner.name_info();
                                }
                                Scanner owner_info = new Scanner(System.in);
                                int id_4 = owner_info.nextInt() - 1;
                                owners.get(id_4).info();
                                break;
                            }
                            case "4": {
                                System.out.println("----------List of the Owners ------------");
                                for (Owner Owner : owners) {
                                    Owner.info();

                                }
                                break;
                            }
                            case "5":
                                System.out.println("To what owner you want to add animal, enter ID");
                                for (Owner Owner : owners) {
                                    Owner.name_info();
                                }
                                Scanner owner_info = new Scanner(System.in);
                                int id_4 = owner_info.nextInt() - 1;
                                System.out.println("What animal you want to add, enter ID");
                                for (Animal animal :animals_to_add)
                                {
                                    animal.info();
                                }
                                int id_5 = owner_info.nextInt() - 1;
                                if(owners.get(id_4).getAnimal_owner()!=null) // if owner has a animal, its add one more
                                {
                                    owners.get(id_4).setAnimal_owner(owners.get(id_4).getAnimal_owner()+" , "+animals.get(id_5).getName() );
                                }
                                else if(owners.get(id_4).getAnimal_owner()==null) { // if owner doesn't have an animal
                                    owners.get(id_4).setAnimal_owner(animals.get(id_5).getName());

                                    animals.get(id_5).setOwner(owners.get(id_4).getName());
                                }
                                animals.get(id_5).setAnimalCount(animals.get(id_5).getAnimalCount()-1); //set animal id in the list animals_to_take
                                                                                                        // on correct value (so they can be properly removed from the list)

                                animals_to_add.remove(id_5);
                                break;
                            case "6":
                                this.menu();
                                break;
                        }
                        break;
                    case "2":
                        System.out.println("1. Add new animal");
                        System.out.println("2. Delete animal");
                        System.out.println("3. Feed animal");
                        System.out.println("4. Move animal");
                        System.out.println("5. Animals List");
                        System.out.println("6. Return to main menu");
                        String animal_choice = reader.readLine();

                        switch (animal_choice) {
                            case "1": {
                                System.out.println("1. Add new Dog");
                                System.out.println("2. Add new Cat");
                                System.out.println("3. Add new Turtle");
                                String animalChoice = reader.readLine();
                                switch (animalChoice) {
                                    case "1":
                                        System.out.println("Enter name");
                                        String dog_name = reader.readLine();
                                        System.out.println("Enter sex");
                                        String dog_sex = reader.readLine();
                                        while (!dog_sex.equals("Male")||!dog_sex.equals("male")||!dog_sex.equals("Female")||!dog_sex.equals("female"))
                                        {
                                            if(dog_sex.equals("Male")||dog_sex.equals("male")||dog_sex.equals("Female")||dog_sex.equals("female")){
                                                break;
                                            }
                                            else {
                                                System.out.println("You have to put male or female");
                                                dog_sex = reader.readLine();
                                            }
                                        }
                                        System.out.println("Enter age");
                                        Scanner input = new Scanner(System.in);

                                        int dog_age = input.nextInt();


                                        System.out.println("Enter race");
                                        String dog_race = reader.readLine();
                                        System.out.println("Enter Id Owner");
                                        if(owners.isEmpty()) { // if the list of the owners is empty, can not add animal
                                            System.out.println("First you have to create a owners\nPress enter to return menu\n");
                                            String enter = reader.readLine();

                                            break;

                                        }
                                        for (Owner Owner : owners) {
                                            Owner.name_info();
                                        }

                                        Scanner sc3 = new Scanner(System.in);
                                        int id7 = sc3.nextInt() - 1;


                                        dog_owner=null;
                                        Dog dog = new Dog(Type = "Dog", dog_name, dog_sex, dog_age, dog_race, dog_owner);
                                        dog.setOwner(owners.get(id7).getName());
                                        if(owners.get(id7).getAnimal_owner()!=null)// if owner has a animal, its add one more
                                        {
                                            owners.get(id7).setAnimal_owner(owners.get(id7).getAnimal_owner()+","+dog.getName());
                                        }
                                        else if(owners.get(id7).getAnimal_owner()==null)// if owner doesn't have animal
                                        {owners.get(id7).setAnimal_owner(dog.getName());}
                                        dog.setX1(1); // sets the dog to position 1.1
                                        dog.setY1(1);


                                        animals.add(dog);
                                        animals_to_add.add(dog);
                                        dogs.add(dog);
                                        AnimalsFileWriter dogFileWriter = new AnimalsFileWriter();
                                        dogFileWriter.saveAnimal(dog);
                                        break;
                                    case "2":
                                        System.out.println("Enter name");
                                        String cat_name = reader.readLine();
                                        System.out.println("Enter sex");
                                        String cat_sex = reader.readLine();
                                        while (!cat_sex.equals("Male")||!cat_sex.equals("male")||!cat_sex.equals("Female")||!cat_sex.equals("female"))
                                        {
                                            if(cat_sex.equals("Male")||cat_sex.equals("male")||cat_sex.equals("Female")||cat_sex.equals("female")){
                                                break;
                                            }
                                            else {
                                                System.out.println("You have to put male or female");
                                                cat_sex = reader.readLine();
                                            }
                                        }
                                        System.out.println("Enter age");

                                        Scanner input3 = new Scanner(System.in);
                                        int cat_age = input3.nextInt();

                                        System.out.println("Enter race");
                                        String cat_race = reader.readLine();
                                        System.out.println("Enter Owner");
                                        if(owners.isEmpty()) {
                                        System.out.println("First you have to create a owners\nPress enter to return menu");
                                        String enter = reader.readLine();

                                        this.menu();
                                        break;
                                    }
                                        if (!owners.isEmpty()) {
                                            for (Owner Owner : owners) {
                                                Owner.name_info();
                                            }
                                            Scanner sc4 = new Scanner(System.in);
                                            int id_2 = sc4.nextInt() - 1;
                                            cat_owner = null;

                                            Cat cat = new Cat(Type = "Cat", cat_name, cat_sex, cat_age, cat_race, cat_owner);
                                            cat.setOwner(owners.get(id_2).getName());
                                            if(owners.get(id_2).getAnimal_owner()==null)
                                            {
                                                owners.get(id_2).setAnimal_owner(cat.getName());

                                            }
                                            else if(owners.get(id_2).getAnimal_owner()!=null)
                                            {
                                                owners.get(id_2).setAnimal_owner(owners.get(id_2).getAnimal_owner()+","+cat.getName());
                                            }

                                            cat.setX1(1);
                                            cat.setY1(1);

                                            animals.add(cat);
                                            animals_to_add.add(cat);
                                            AnimalsFileWriter catFileWriter = new AnimalsFileWriter();
                                            catFileWriter.saveAnimal(cat);
                                        }
                                        break;

                                    case "3":
                                        System.out.println("Enter name");
                                        String turtle_name = reader.readLine();
                                        System.out.println("Enter sex");
                                        String turtle_sex = reader.readLine();
                                        while (!turtle_sex.equals("Male")||!turtle_sex.equals("male")||!turtle_sex.equals("Female")||!turtle_sex.equals("female"))
                                        {
                                            if(turtle_sex.equals("Male")||turtle_sex.equals("male")||turtle_sex.equals("Female")||turtle_sex.equals("female")){
                                                break;
                                            }
                                            else {
                                                System.out.println("You have to put male or female");
                                                turtle_sex = reader.readLine();
                                            }
                                        }
                                        System.out.println("Enter age");
                                        Scanner input2 = new Scanner(System.in);
                                        int turtle_age = input2.nextInt();
                                        System.out.println("Enter Owner");
                                        if(owners.isEmpty()) {
                                        System.out.println("First you have to create a owners\nPress enter to return menu");
                                        String enter = reader.readLine();

                                        this.menu();
                                        break;
                                    }

                                        if (!owners.isEmpty()) {
                                            for (Owner Owner : owners) {
                                                Owner.name_info();
                                            }
                                            Scanner sc5 = new Scanner(System.in);
                                            int id_3 = sc5.nextInt() - 1;
                                            turtle_owner = null;


                                            Turtle turtle = new Turtle(Type = "Turtle", turtle_name, turtle_sex, turtle_age, turtle_race, turtle_owner);
                                            turtle.setOwner(owners.get(id_3).getName());
                                            if(owners.get(id_3).getAnimal_owner()==null)
                                            {owners.get(id_3).setAnimal_owner(turtle.getName());}
                                            else if(owners.get(id_3).getAnimal_owner()!=null)
                                            {
                                                owners.get(id_3).setAnimal_owner(owners.get(id_3).getAnimal_owner()+","+turtle.getName());
                                            }

                                            turtle.setX1(1);
                                            turtle.setY1(1);
                                            turtle.setStatus(Turtle.Status.INACTIVE); // set the turtle to inactive status right after creating the turtle
                                            animals.add(turtle);
                                            animals_to_add.add(turtle);
                                            turtles.add(turtle);

                                            TurtlesFileWriter turtleFileWriter = new TurtlesFileWriter();
                                            turtleFileWriter.saveTurtle(turtle);

                                            break;
                                        }
                                }
                                break;
                            }
                            case "2": {
                                System.out.println("Enter ID animal you want to delete ");
                                for (Animal animal : animals) {
                                    animal.name_info();
                                }

                                Scanner sc6 = new Scanner(System.in);
                                int id_3 = sc6.nextInt()-1; // -1 because the real index is always a number -1 smaller

                                for(Owner owner :owners) {

                                    if (owner.getAnimal_owner()!=null&&owner.getAnimal_owner().contains(animals.get(id_3).getName()))
                                    {

                                        animals.get(id_3).setOwner(null);
                                        owner.setAnimal_owner(null);


                                    }
                                    animals.get(id_3).setAnimalCount(animals.get(id_3).getAnimalCount()-1); // set correct id after removing the owner
                                    animals.removeIf(animal -> animal.getID() == (id_3)+1);
                                    animals_to_add.removeIf(animal -> animal.getID() == (id_3)+1);

                                    //------individual animal removal does not work--------

                                  //  for (Animal animal:animals_to_add){
                                   // owner.setAnimal_owner(animal.getName()); //

                                  //  }

                                }

                                break;
                            }

                            case "3": {
                                System.out.println("Enter ID turtle you want to feed ");
                                for (Turtle Turtle : turtles) {
                                    Turtle.name_info();

                                }
                                Scanner sc2 = new Scanner(System.in);
                                int x = sc2.nextInt()-1 ;
                                turtles.get(x-animals.size()+1).setStatus(Turtle.Status.ACTIVE); // after feeding the turtle his status change to active
                                System.out.println(turtles.get(x-animals.size()+1).getType() + " " + turtles.get(x-animals.size()+1).getName() + " is " + turtles.get(x-animals.size()+1).getStatus());
                                break;

                            }
                            case "4": {
                                System.out.println("With animal you want to move");

                                for (Animal Animal : animals) {
                                    Animal.name_info();

                                }
                                System.out.println("Enter ID animal you want to move");
                                Scanner sc = new Scanner(System.in);
                                int x = sc.nextInt() - 1;
                                System.out.println("1. Move up");
                                System.out.println("2. Move down");
                                System.out.println("3. Move left");
                                System.out.println("4. Move right");
                                String move_choice = reader.readLine();
                                if (move_choice.equals("1")) {

                                    if (animals.get(x).getX1() != 15) { // the animal will not move to a value higher than 15
                                        int x1 = animals.get(x).getX1();
                                        System.out.println(animals.get(x).getName() + " move from " + animals.get(x).position());
                                        animals.get(x).setX1(x1 + 1);

                                        System.out.println(" to " + animals.get(x).position());
                                        // twisting get (x) for turtles because turtles index is different from animals index,

                                    if (animals.get(x).getType().equals("Turtle")){ // if the animal is a turtle and it is inactive, it can't move
                                        if (turtles.get(x- animals.size()+1).getStatus() == Turtle.Status.INACTIVE) {
                                            int x2 = animals.get(x).getX1();
                                            animals.get(x).setX1(x2 - 1);
                                            System.out.println("Turtle status is inactive, he cant move right now. His position is " + animals.get(x).position());

                                        }
                                        else if (turtles.get(x-animals.size()+1).getStatus() == Turtle.Status.ACTIVE) { // if the turtle was active and moved, it changes its value to inactive
                                            turtles.get(x-animals.size()+1).setStatus(Turtle.Status.INACTIVE);
                                            System.out.println("Turtle changed status from active to inactive");
                                    }
                                    }
                                    }

                                if (animals.get(x).getX1() > 15) {
                                    System.out.println("Animal try to move over fence");
                                }

                                break;

                                }
                                if (move_choice.equals("2")) {
                                    if (animals.get(x).getX1() != 1) {// the animal cannot exceed the value of 1
                                        int x2 = animals.get(x).getX1();
                                        System.out.println(animals.get(x).getName() + " move from " + animals.get(x).position());
                                        animals.get(x).setX1(x2 - 1);

                                        System.out.println(" to " + animals.get(x).position());

                                        if (animals.get(x).getType().equals("Turtle")) {
                                            if (turtles.get(x-animals.size()+1).getStatus() == Turtle.Status.INACTIVE) {
                                                int x3 = animals.get(x).getX1();
                                                animals.get(x).setX1(x3 + 1);
                                                System.out.println("Turtle status is inactive, he cant move right now. His position is " + animals.get(x).position());

                                            } else if (turtles.get(x-animals.size()+1).getStatus() == Turtle.Status.ACTIVE) {
                                                turtles.get(x-animals.size()+1).setStatus(Turtle.Status.INACTIVE);
                                                System.out.println("Turtle changed status from active to inactive");
                                            }
                                        }
                                    }
                                    if(animals.get(x).getX1() < 1)
                                    {
                                        System.out.println("Animal try to move over fence");
                                    }
                                    break;

                                }
                                if (move_choice.equals("3")) {
                                    if (animals.get(x).getY1() != 15) {
                                        int y1 = animals.get(x).getY1();
                                        System.out.println(animals.get(x).getName() + " move from " + animals.get(x).position());
                                        animals.get(x).setY1(y1 + 1);

                                        System.out.println(" to " + animals.get(x).position());

                                        if (animals.get(x).getType().equals("Turtle")) {
                                            if (turtles.get(x-animals.size()+1).getStatus() == Turtle.Status.INACTIVE) {
                                                int y2 = animals.get(x).getY1();
                                                animals.get(x).setY1(y2 - 1);
                                                System.out.println("Turtle status is inactive, he cant move right now. His position is " + animals.get(x).position());

                                            } else if (turtles.get(x-animals.size()+1).getStatus() == Turtle.Status.ACTIVE) {
                                                turtles.get(x-animals.size()+1).setStatus(Turtle.Status.INACTIVE);
                                                System.out.println("Turtle changed status from active to inactive");
                                            }
                                        }
                                    }
                                    if(animals.get(x).getY1() > 15)
                                    {
                                        System.out.println("Animal try to move over fence");
                                    }
                                    break;
                                }
                                if (move_choice.equals("4")) {
                                    if (animals.get(x).getY1() != 1) {
                                        int y2 = animals.get(x).getY1();
                                        System.out.println(animals.get(x).getName() + " move from " + animals.get(x).position());
                                        animals.get(x).setY1(y2 - 1);

                                        System.out.println(" to " + animals.get(x).position());

                                        if (animals.get(x).getType().equals("Turtle")) {
                                            if (turtles.get(x-animals.size()+1).getStatus() == Turtle.Status.INACTIVE) {
                                                int y3 = animals.get(x).getY1();
                                                animals.get(x).setY1(y3 + 1);
                                                System.out.println("Turtle status is inactive, he cant move right now. His position is " + animals.get(x).position());

                                            } else if (turtles.get(x-animals.size()+1).getStatus() == Turtle.Status.ACTIVE) {
                                                turtles.get(x-animals.size()+1).setStatus(Turtle.Status.INACTIVE);
                                                System.out.println("Turtle changed status from active to inactive");
                                            }
                                        }
                                    }
                                    if(animals.get(x).getY1() < 1)
                                    {
                                        System.out.println("Animal try to move over fence");
                                    }

                                    break;
                                }
                            }

                            case "5": {
                                System.out.println("----------List of the Animals ------------");
                                for (Animal Animal : animals) {
                                    Animal.info();
                                }
                                break;
                            }
                            case "6":
                                this.menu();
                        }
                        break;
                    case "3":
                        System.out.println("1. Check Turtle Activity");
                        System.out.println("2. Show Garden");
                        System.out.println("3. Load Owners");
                        System.out.println("4. Load Animals");
                        System.out.println("5. Load Turtles");
                        System.out.println("6. Return to main menu");
                        String others_choice = reader.readLine();
                        switch (others_choice) {
                            case "1":
                                System.out.println("Enter ID turtle you want to check"); // shows the status of the selected turtle
                                for (Turtle Turtle : turtles) {
                                    Turtle.name_info();
                                }
                                Scanner sc1 = new Scanner(System.in);
                                int x = sc1.nextInt() - 1;
                                System.out.println(turtles.get(x-animals.size()+1).getType() + " " + turtles.get(x-animals.size()+1).getName() + " is " + turtles.get(x-animals.size()+1).getStatus());
                                break;
                            case "2": // shows the positions of animals in the garden
                                for (Animal Animal : animals) {
                                    System.out.println(Animal.getType() + " " + Animal.getName() + " is on position " + Animal.getX1() + ", " + Animal.getY1());

                                }
                                break;
                            case "3": // load owners
                                loadOwner();

                                break;
                            case"4": // load animals
                                loadAnimal();

                                break;
                            case"5": // load turtles
                                loadTurtle();
                                break;
                            case"6":
                                this.menu();

                        }
                        break;
                    case "4":
                        for (Owner Owner : owners) {
                            Owner.setAge(Owner.getAge()+1);

                        }
                        for (Animal Animal :animals)
                        {
                            Animal.setAge(Animal.getAge()+1);
                        }

                        animals.removeIf(Animal->Animal.getAge()==(20));

                        animals_to_add.removeIf(Animal -> Animal.getAge() == (20));
                    default:
                        throw new IllegalStateException("Unexpected value: " + choice);
                }

            }

        } catch (InputMismatchException e) {

            System.out.println("Something went wrong, try again");
            this.menu();
        }
        catch (IndexOutOfBoundsException e)
        {

            System.out.println("Something went wrong, try again");
            this.menu();
        }
        catch (IllegalStateException e)
        {
            System.out.println("Enter 1-4 value");
            this.menu();
        }

    }
    private Owner loadOwner(){
        Owner sss = null;
        try {
                Scanner scanner = new Scanner(new File("owner.txt"));
                 while (scanner.hasNext()) {
                     long id = scanner.nextLong();
                     String Name = scanner.next();
                     String LastName = scanner.next();
                     Scanner input = new Scanner(System.in);
                     int Age = scanner.nextInt();
                     String Sex = scanner.next();
                     sss = new Owner(Name, LastName, Sex, Age,animal_owner);
                     owners.add(sss);
                 }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sss;
    }
    private Animal loadAnimal(){
        Animal sx = null;
        try {
            Scanner scanner = new Scanner(new File("animals.txt"));
            while (scanner.hasNext())
            {
                long id = scanner.nextLong();
                String Sex = scanner.next();
                Scanner input = new Scanner(System.in);
                int Age=scanner.nextInt();
                String Race = scanner.next();
                String Type = scanner.next();
                String Name = scanner.next();
                String owner = scanner.next();

                sx = new Animal(Name,Sex,Race,Age,Type,owner);
                sx.setX1(1);
                sx.setY1(1);
                animals.add(sx);
                animals_to_add.add(sx);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sx;
    }
    private Turtle loadTurtle(){
        Turtle sc = null;
        try {
            Scanner scanner = new Scanner(new File("turtles.txt"));
            while (scanner.hasNext())
            {
                String Race = scanner.next();
                String Sex = scanner.next();
                String Type = scanner.next();
                int Age = scanner.nextInt();
                String Name = scanner.next();
                String owner = scanner.next();


                sc = new Turtle(Name,Sex,Type,Age,Race=null,owner);
                sc.setX1(1);
                sc.setY1(1);
                sc.setStatus(Turtle.Status.INACTIVE);
                animals.add(sc);
                animals_to_add.add(sc);
                turtles.add(sc);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sc;
    }
}















