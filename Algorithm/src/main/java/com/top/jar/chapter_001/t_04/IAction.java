package com.top.jar.chapter_001.t_04;

import com.top.jar.chapter_001.t_04.pet.Cat;
import com.top.jar.chapter_001.t_04.pet.Dog;
import com.top.jar.chapter_001.t_04.pet.Pet;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-18 11:52
 * @Desc :
 */
public interface IAction<T extends Pet> {

    void add(T t);

    T pollAll();

    Dog pollDog();

    Cat pollCat();

    boolean isEmpty();

    boolean isDogEmpty();

    boolean isCatEmpty();

}
