import java.io.Serializable;

public class Clients implements Serializable {
    String name;
    String surname;
    String login;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    Count count = new Count();

    public Clients(){};

    public Clients(String name, String surname){
        this.name=name;
        this.surname=surname;
    };

    String makeAccNum(){
        String a = String.valueOf((int)(Math.random()*10-1));
        String b = String.valueOf((int)(Math.random()*10-1));
        String c = String.valueOf((int)(Math.random()*10-1));
        String d = String.valueOf((int)(Math.random()*10-1));
        String e = String.valueOf((int)(Math.random()*10-1));
        this.count.number="31140000"+a+b+c+d+e;
        return count.number;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login=" + login +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clients)) return false;

        Clients clients = (Clients) o;

        if (!login.equals(clients.login)) return false;
        if (!getPassword().equals(clients.getPassword())) return false;
        return count.equals(clients.count);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + count.hashCode();
        return result;
    }
}
