package behavioral_design_pattern.strategy;

public class StrategyPatternMain {

    // client code here
    private static void execute(Strategy strategy) {
        strategy.solve();
    }

    public static void main( String[] args ) {
        Strategy[] algorithms = {new FOO(), new BAR()};
        for (Strategy algorithm : algorithms) {
            execute(algorithm);
        }
    }
}

// 1. Define the interface of the algorithm
interface Strategy {
    void solve();
}

// 2. Bury implementation
abstract class StrategySolution implements Strategy {
    // 3. Template Method
    public void solve() {
        start();
        while (nextTry() && !isSolution()) {}
        stop();
    }

    abstract void start();
    abstract boolean nextTry();
    abstract boolean isSolution();
    abstract void stop();
}

// 2. Bury implementation
abstract class StrategySearch implements Strategy {
    // 3. Template Method
    public void solve() {
        while (true) {
            preProcess();
            if (search()) {
                break;
            }
            postProcess();
        }
    }

    abstract void preProcess();
    abstract boolean search();
    abstract void postProcess();
}

class FOO extends StrategySolution {
    private int state = 1;

    protected void start() {
        System.out.println("Start  ");
    }

    protected void stop() {
        System.out.println("Stop");
    }

    protected boolean nextTry() {
        System.out.println("NextTry-" + state++ + "  ");
        return true;
    }

    protected boolean isSolution() {
        System.out.println("IsSolution-" + (state == 3) + "  ");
        return (state == 3);
    }
}


class BAR extends StrategySearch {
    private int state = 1;

    protected void preProcess()  {
        System.out.println("PreProcess  ");
    }

    protected void postProcess() {
        System.out.println("PostProcess  ");
    }

    protected boolean search() {
        System.out.println("Search-" + state++ + "  ");
        return state == 3;
    }
}