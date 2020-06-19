package com.top.jar.chapter_001.t_04.zuo;

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
            if (mDogQueue.peek().getCount() < mCatQueue.peek().getCount()) {
                return mDogQueue.poll().getPet();
            }
            return mCatQueue.poll().getPet();
        } else if (!mDogQueue.isEmpty()) {
            return mDogQueue.poll().getPet();
        } else if (!mCatQueue.isEmpty()) {
            return mCatQueue.poll().getPet();
        }

        throw new RuntimeException("err,queue is empty.");
    }

    public Dog pollDog(){
        if (mDogQueue.isEmpty()) {
            throw new RuntimeException("queue is empty.");
        }
        return (Dog) mDogQueue.poll().getPet();
    }


}
