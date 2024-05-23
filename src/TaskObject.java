public class TaskObject implements ITask {
    private int number;
    private int result;

    @Override
    public void setExecNumber(int x) {
        this.number = x;
    }

    @Override
    public void exec() {
        this.result = findLargestPrime(number);
    }

    @Override
    public int getResult() {
        return result;
    }

    private int findLargestPrime(int x) {
        for (int i = x; i >= 2; i--) {
            if (isPrime(i)) {
                return i;
            }
        }
        return -1; // No prime found
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
