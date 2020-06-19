package com.top.jar.chapter_001.t_04.zuo;

import com.top.jar.chapter_001.t_04.pet.Cat;
import com.top.jar.chapter_001.t_04.pet.Dog;
import com.top.jar.chapter_001.t_04.pet.Pet;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-19 11:29
 * @Desc :
 */
public class DogCatQueue {
    private Queue<PetEnterQueue> mDogQueue;
    private Queue<PetEnterQueue> mCatQueue;

    private              long   mCount = 0;
    private static final String DOG    = "dog";
    private static final String CAT    = "cat";

    public DogCatQueue() {
        mDogQueue = new LinkedList<>();
        mCatQueue = new LinkedList<>();
    }

    public void add(Pet pet) {
        if (DOG.equals(pet.getType())) {
            mDogQueue.add(new PetEnterQueue(pet, mCount++));
            return;
        }
        if (CAT.equals(pet.getType())) {
            mCatQueue.add(new PetEnterQueue(pet, mCount++));
            return;
        }
        throw new RuntimeException("err,not dog or cat");
    }

    public Pet pollAll() {
        if (!mDogQueue.isEmpty() && !mCatQueue.isEmpty()) {
            // poll dog；
            if (mDogQueue.peek().getCount() < mCatQueue.peek().getCount()) {
                return mDogQueue.poll().getPet();
            }
            // poll cat;
            return mCatQueue.poll().getPet();

        } else if (!mDogQueue.isEmpty()) {
            // cat queue ie empty.
            return mDogQueue.poll().getPet();
        } else if (!mCatQueue.isEmpty()) {
            return mCatQueue.poll().getPet();
        }

        throw new RuntimeException("err,queue is empty.");
    }

    public Dog pollDog() {
        if (mDogQueue.isEmpty()) {
            throw new RuntimeException("queue is empty.");
        }
        return (Dog) mDogQueue.poll().getPet();
    }


    /**
     * 队列是否为空？
     *
     * @return
     */
    public boolean isEmpty() {
        return mDogQueue.isEmpty() && mCatQueue.isEmpty();
    }

    public boolean isDogQueueEmpty() {
        if (mDogQueue == null) {
            throw new RuntimeException("Dog queue is empty.");
        }
        return mDogQueue.isEmpty();
    }


    public boolean isCatQueueEmpty() {
        if (mCatQueue == null) {
            throw new RuntimeException("Cat queue is empty");
        }

        return mCatQueue.isEmpty();
    }


    public static void main(String[] args) {
        DogCatQueue petQueue = new DogCatQueue();

        Cat catOne = new Cat("cat");
        Cat catTwo = new Cat("cat");
        Cat catThree = new Cat("cat");
        Cat catFour = new Cat("cat");
        petQueue.add(catOne);
        petQueue.add(catTwo);
        petQueue.add(catThree);
        petQueue.add(catFour);

        Dog dogOne = new Dog("dog");
        Dog dogTwo = new Dog("dog");
        Dog dogThree = new Dog("dog");
        Dog dogFour = new Dog("dog");
        petQueue.add(dogOne);
        petQueue.add(dogTwo);
        petQueue.add(dogThree);
        petQueue.add(dogFour);


        boolean isEmpty = petQueue.isEmpty();
        System.out.println(" is empty :" + isEmpty);
        Pet pet = petQueue.pollAll();
        String type = pet.getType();
        System.out.println("poll pet type : "+ type);


    }


}
