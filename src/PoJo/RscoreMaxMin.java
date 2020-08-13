package PoJo;

/**
 * @author zhuxingqi
 * @version 1.0
 * @date 2019/5/6
 */
public class RscoreMaxMin {
    private float max;
    private float min;

    @Override
    public String toString() {
        return "RscoreMaxMin{" +
                "max=" + max +
                ", min=" + min +
                '}';
    }

    public RscoreMaxMin() {
    }

    public RscoreMaxMin(float max, float min) {
        this.max = max;
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }
}
