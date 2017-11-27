public class CalcTwoImp implements IColc{

    @Override
    public double sum(double a, double b) {
        return a+b*2;
    }

    @Override
    public double raznost(double a, double b) {
        return a-b*2;
    }
}
