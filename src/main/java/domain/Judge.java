package domain;

import java.io.Serializable;

public class Judge implements Serializable {

    private int id;

    private String username;

    public Judge() {
    }

    public Judge(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Judge)) return false;

        Judge judge = (Judge) o;

        if (id != judge.id) return false;
        return username != null ? username.equals(judge.username) : judge.username == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Judge{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
