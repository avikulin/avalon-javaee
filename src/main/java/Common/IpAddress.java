package Common;

public class IpAddress {
    int fist;
    int second;
    int third;
    int fourth;

    public IpAddress(int first, int second, int third, int fourth) {
        setFist(first);
        setSecond(second);
        setThird(third);
        setFourth(fourth);
    }

    private void checkOctet(int octet){
        if(octet > 0 && octet < 255)
            return;
        throw new IllegalArgumentException("Each octet value must be between 0 and 254.");
    }

    private void setFist(int fist) {
        checkOctet(fist);
        this.fist = fist;
    }

    private void setSecond(int second) {
        checkOctet(second);
        this.second = second;
    }

    private void setThird(int third) {
        checkOctet(third);
        this.third = third;
    }

    private void setFourth(int fourth) {
        checkOctet(fourth);
        this.fourth = fourth;
    }

    public int getFist() {
        return fist;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    @Override
    public String toString() {
        return String.valueOf(fist) +
                '.' +
                second +
                '.' +
                third +
                '.' +
                fourth;
    }
}
