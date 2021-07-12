package logic.Sort;

import logic.DataClass;

public class StateMachine {
    public VisibleSort currentState;

    public void initStateMachine(int value) {
        currentState = DataClass.getInstance().sort;
        currentState.startSort(value);
    }

    public boolean doStep() {
        currentState.makeStep();
        return currentState.next();
    }
    public void resetState(){
        DataClass.getInstance().mainArray = DataClass.getInstance().safeArray;
        DataClass.getInstance().speed = 48;
        DataClass.getInstance().elem1 = -1;
        DataClass.getInstance().elem2 = -1;

        currentState.stop();
    }
}
