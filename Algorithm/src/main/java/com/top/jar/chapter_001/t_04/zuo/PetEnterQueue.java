package com.top.jar.chapter_001.t_04.zuo;

import com.top.jar.chapter_001.t_04.pet.Pet;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-19 11:30
 * @Desc :
 */
public class PetEnterQueue {
    private Pet  mPet;
    private long mCount;

    public PetEnterQueue(Pet pet, long count) {
        mPet = pet;
        mCount = count;
    }

    public Pet getPet() {
        return mPet;
    }

    public long getCount() {
        return mCount;
    }


    public String getEnterType() {
        if (mPet == null) {
            return "";
        }
        return mPet.getType();
    }
}
