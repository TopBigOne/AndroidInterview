package com.jar.pattern.state.test;

import com.jar.pattern.state.GumballMachine;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/5/11 16:21
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        // check state
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        // check state
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        // check state
        System.out.println(gumballMachine);


    }
}
