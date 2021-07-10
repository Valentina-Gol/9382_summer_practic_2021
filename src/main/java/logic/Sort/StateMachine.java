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
}
