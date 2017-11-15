public class CalcTwoImp implements IColc{

    @Override
    public int sum(int a, int b) {
        return a+b*2;
    }

    @Override
    public int raznost(int a, int b) {
        return a-b*2;
    }
}
