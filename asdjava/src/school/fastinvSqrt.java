package school;

public class fastinvSqrt {
    public static void main(String[] args) {
        System.out.println(invSqrt(4.0f));
    }
    public static float invSqrt(float x) {
        float xhalf = 0.5f * x;
        int i = Float.floatToIntBits(x);
        System.out.println(i);
        i = 0x5f3759df - (i >> 1);
        System.out.println(i);
        x = Float.intBitsToFloat(i);
        System.out.println(x);
        x *= (1.5f - xhalf * x * x);
        System.out.println(x);
        return x;
    }
    public static double invSqrt(double x) {
        double xhalf = 0.5d * x;
        long i = Double.doubleToLongBits(x);
        i = 0x5fe6ec85e7de30daL - (i >> 1);
        x = Double.longBitsToDouble(i);
        x *= (1.5d - xhalf * x * x);
        return x;
    }
}
