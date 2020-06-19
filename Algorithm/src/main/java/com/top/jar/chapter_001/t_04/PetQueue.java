package com.top.jar.chapter_001.t_04;

import com.top.jar.chapter_001.t_04.pet.Cat;
import com.top.jar.chapter_001.t_04.pet.Dog;
import com.top.jar.chapter_001.t_04.pet.Pet;

import java.util.Stack;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-18 11:51
 * @Desc :
 */
public class PetQueue implements IAction<Pet> {
    private Stack<Pet> mAllPet;
    private Stack<Dog> mDogStack;
    private Stack<Cat> mCatStack;

    public PetQueue() {
        mAllPet = new Stack<>();
        mDogStack = new Stack<>();
        mCatStack = new Stack<>();
    }

    @Override
    public void add(Pet pet) {
        mAllPet.push(pet);
        if (pet instanceof Dog) {
            mDogStack.push((Dog) pet);
            return;
        }

        if (pet instanceof Cat) {
            mCatStack.push((Cat) pet);
        }

    }

    @Override
    public Pet pollAll() {
        if (mAllPet.isEmpty()) {
            throw new RuntimeException("No pet in this stack");
        }

        while (!mAllPet.isEmpty()) {
            Pet pet = mAllPet.pop();
            System.out.println("Pet type :" + pet.getType());
        }

        return null;
    }

    @Override
    public Dog pollDog() {
        if (mDogStack.isEmpty()) {
            throw new RuntimeException("No pet in this stack");
        }

        while (!mDogStack.isEmpty()) {
            Dog dog = mDogStack.pop();
            System.out.println("Dog type :" + dog.getType());
        }

        return null;
    }

    @Override
    public Cat pollCat() {
        if (mCatStack.isEmpty()) {
            throw new RuntimeException("No pet in this stack");
        }

        while (!mCatStack.isEmpty()) {
            Cat cat = mCatStack.pop();
            System.out.println("Cat type :" + cat.getType());
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return mAllPet.isEmpty();
    }

    @Override
    public boolean isDogEmpty() {
        return mDogStack.isEmpty();
    }

    @Override
    public boolean isCatEmpty() {
        return mCatStack.isEmpty();
    }


    public static void main(String[] args) {
        PetQueue petQueue = new PetQueue();

        Cat catOne = new Cat("cat one");
        Cat catTwo = new Cat("cat two");
        Cat catThree = new Cat("cat three");
        Cat catFour = new Cat("cat four");
        petQueue.add(catOne);
        petQueue.add(catTwo);
        petQueue.add(catThree);
        petQueue.add(catFour);

        Dog dogOne = new Dog("dog one");
        Dog dogTwo = new Dog("dog two");
        Dog dogThree = new Dog("dog three");
        Dog dogFour = new Dog("dog four");
        petQueue.add(dogOne);
        petQueue.add(dogTwo);
        petQueue.add(dogThree);
        petQueue.add(dogFour);


        boolean isEmpty = petQueue.isEmpty();
        System.out.println(" is empty :" + isEmpty);
        petQueue.pollAll();

    }
}
