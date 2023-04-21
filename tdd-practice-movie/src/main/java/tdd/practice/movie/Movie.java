package tdd.practice.movie;

public class Movie {
    private int rate;
    private int callRateCount;

    public Integer getAverage() {
        if (callRateCount == 0) {
            return 0;
        }

        return rate / callRateCount;
    }

    public void rate(int rate) {
        this.rate += rate;
        this.callRateCount++;
    }
}
