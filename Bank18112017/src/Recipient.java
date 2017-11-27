public class Recipient {

    String name;
    Count count = new Count();

    public Recipient(){};

    public Recipient(String name, Count count){
        this.name=name;
        this.count=count;
    };
    public Recipient(String name){
        this.name=name;
    };


    @Override
    public String toString() {
        return "Recipients{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

}
