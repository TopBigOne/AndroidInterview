package com.jar.pattern.state;

import com.jar.pattern.state.base.State;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/5/11 15:43
 * @Url :
 * @Level :  easy  medium hard
 * @Desc : 完整的糖果机类
 * @Counter :
 * @Answer :
 */
public class GumballMachine {
    private final State soldOutState;
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    private final State winnerState;

    private State state = null;
    private int count = 0;

    /**
     * @param numberGumballs 糖果数量
     */
    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }


    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }


    void replaceBall() {
        System.out.println("A gumball comes rolling out the slot....");
        if (count != 0) {
            count -= 1;
        }
    }


    void setState(State state) {
        this.state = state;
    }


    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public int getCount() {
        return count;
    }

    void refill(int count) {
        this.count += count;
        System.out.println("The gumball machine was just refilled; it's new count is: " + this.count);
        state.refill();
    }


    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: ").append(count).append(" gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is ").append(state).append("\n");
        return result.toString();
    }

}
