package behavioral_design_pattern.strategy;

/**
 * @author a1101381
 */
public class StrategyPatternMain {

    // client code here
    private static void execute(Strategy strategy) {
        strategy.solve();
    }

    public static void main( String[] args ) {
        Strategy[] algorithms = {new Foo(), new Bar()};
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
abstract class AbstractStrategySolution implements Strategy {
    // 3. Template Method
    @Override
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
abstract class AbstractStrategySearch implements Strategy {
    // 3. Template Method
    @Override
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

class Foo extends AbstractStrategySolution {
    private int state = 1;

    @Override
    protected void start() {
        System.out.println("Start  ");
    }

    @Override
    protected void stop() {
        System.out.println("Stop");
    }

    @Override
    protected boolean nextTry() {
        System.out.println("NextTry-" + state++ + "  ");
        return true;
    }

    @Override
    protected boolean isSolution() {
        System.out.println("IsSolution-" + (state == 3) + "  ");
        return (state == 3);
    }
}


class Bar extends AbstractStrategySearch {
    private int state = 1;

    @Override
    protected void preProcess()  {
        System.out.println("PreProcess  ");
    }

    @Override
    protected void postProcess() {
        System.out.println("PostProcess  ");
    }

    @Override
    protected boolean search() {
        System.out.println("Search-" + state++ + "  ");
        return state == 3;
    }
}