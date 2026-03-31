import java.util.ArrayList;
import java.util.LinkedList;

class Animal {
    int animalId;
    String animalName;

    Animal(int animalId, String animalName) {
        this.animalId = animalId;
        this.animalName = animalName;
    }

    void display() {
        System.out.println("Animal ID: " + animalId + " Animal Name: " + animalName);
    }
}

public class AnimalSystem {
    public static void main(String[] args) {

        ArrayList<Animal> sectionA = new ArrayList<>();

        sectionA.add(new Animal(1,"Cow"));
        sectionA.add(new Animal(2,"Goat"));
        sectionA.add(new Animal(3,"Sheep"));
        sectionA.add(new Animal(4,"Horse"));
        sectionA.add(new Animal(5,"Pig"));
        sectionA.add(new Animal(6,"Buffalo"));
        sectionA.add(new Animal(7,"Donkey"));
        sectionA.add(new Animal(8,"Rabbit"));
        sectionA.add(new Animal(9,"Hen"));

        System.out.println("Section A (ArrayList Animals):");

        for(Animal a : sectionA){
            a.display();
        }

        sectionA.remove(2);

        System.out.println("\nAfter removing one animal from Section A:");

        for(Animal a : sectionA){
            a.display();
        }

        LinkedList<Animal> sectionB = new LinkedList<>();

        sectionB.add(new Animal(101,"Dog"));
        sectionB.add(new Animal(102,"Cat"));
        sectionB.add(new Animal(103,"Duck"));
        sectionB.add(new Animal(104,"Turkey"));
        sectionB.add(new Animal(105,"Peacock"));
        sectionB.add(new Animal(106,"Parrot"));

        System.out.println("\nSection B (LinkedList Animals):");

        for(Animal a : sectionB){
            a.display();
        }

        sectionB.removeFirst();

        System.out.println("\nAfter removing first animal from Section B:");

        for(Animal a : sectionB){
            a.display();
        }
    }
}