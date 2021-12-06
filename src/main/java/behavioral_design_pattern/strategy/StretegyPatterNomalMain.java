package behavioral_design_pattern.strategy;

/**
 * @author a1101381
 */
public class StretegyPatterNomalMain {

    public static void main(String[] args) {
        Context ctx = new Context(new OctaConverter());
        System.out.println(ctx.convert(1000));
    }
}

/**
 * This is Recode
 *     private ConvertingStrategy strategy;
 *
 *     public Context(ConvertingStrategy strategy) {
 *         this.strategy = strategy;
 *     }
 *
 *     public String convert(int number) {
 *         return strategy.convert(number);
 *     }
 *
 */
record Context(ConvertingStrategy strategy) {
    public String convert(int number) {
        return strategy.convert(number);
    }
}

interface ConvertingStrategy {
    String convert(int number);
}

class BinaryConverter implements ConvertingStrategy {
    @Override
    public String convert(int number) {
        return Integer.toBinaryString(number);
    }
}

class OctaConverter implements ConvertingStrategy {
    @Override
    public String convert(int number) {
        return Integer.toOctalString(number);
    }
}