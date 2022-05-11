package com.jar.pattern.state;

import com.jar.pattern.state.base.State;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/5/11 15:38
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class WinnerState implements State {
    GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a Gumball");

    }

    @Override
    public void ejectQuarter() {
        System.out.println("Please wait, we're already giving you a Gumball");

    }

    @Override
    public void turnCrank() {
        System.out.println("Turning again doesn't get you another gumball!");

    }

    @Override
    public void dispense() {
        gumballMachine.replaceBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.replaceBall();
            System.out.println("YOU'RE A WINNER! You got two gumballs for your quarter");
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("Oops ,out of gumballs");
                gumballMachine.setState(gumballMachine.getSoldState());
            }

        }

    }


    @Override
    public void refill() {

    }

    @Override
    public String toString() {
        return "dispensing two gumballs for your quarter, because YOU'RE A WINNER!";
    }
}
