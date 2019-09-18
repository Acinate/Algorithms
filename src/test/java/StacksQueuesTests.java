package test.java;

import algorithms.stacks_queues.AnimalShelter.AnimalQueue;
import algorithms.stacks_queues.AnimalShelter.Cat;
import algorithms.stacks_queues.AnimalShelter.Dog;
import algorithms.stacks_queues.SortStack.SortStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StacksQueuesTests {

    SortStack sortStack = new SortStack();
    AnimalQueue animalQueue = new AnimalQueue();

    @Test
    public void testSortStack() {
        Stack<Integer> testStack1 = new Stack<>();
        testStack1.add(5);
        testStack1.add(3);
        testStack1.add(1);
        testStack1.add(2);
        testStack1.add(4);
        sortStack.sortStack(testStack1);

        List<Integer> values = new ArrayList<>();
        while (!testStack1.isEmpty()) {
            values.add(testStack1.pop());
        }

        Assertions.assertEquals(values.toArray()[0], new int[] { 1, 2, 3, 4, 5 }[0]);
        Assertions.assertEquals(values.toArray()[1], new int[] { 1, 2, 3, 4, 5 }[1]);
        Assertions.assertEquals(values.toArray()[2], new int[] { 1, 2, 3, 4, 5 }[2]);
        Assertions.assertEquals(values.toArray()[3], new int[] { 1, 2, 3, 4, 5 }[3]);
        Assertions.assertEquals(values.toArray()[4], new int[] { 1, 2, 3, 4, 5 }[4]);
    }

    @Test
    public void testAnimalShelter() {
        Dog dog1 = new Dog("Jimmy");
        Dog dog2 = new Dog("Beast");
        Dog dog3 = new Dog("Yogo");
        Cat cat1 = new Cat("Candy");
        Cat cat2 = new Cat("Moonlight");
        animalQueue.enqueue(dog1);
        animalQueue.enqueue(cat1);
        animalQueue.enqueue(dog2);
        animalQueue.enqueue(cat2);
        animalQueue.enqueue(dog3);
        Assertions.assertEquals(animalQueue.dequeueDogs(), dog1);
        Assertions.assertEquals(animalQueue.dequeueCats(), cat1);
        Assertions.assertEquals(animalQueue.dequeueAny(), dog2);
        Assertions.assertEquals(animalQueue.dequeueAny(), cat2);
        Assertions.assertEquals(animalQueue.dequeueAny(), dog3);
    }
}
