package domain;

import java.io.Serializable;
import java.util.Objects;

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
        if (o == null || getClass() != o.getClass()) return false;
        Judge judge = (Judge) o;
        return id == judge.id &&
                Objects.equals(username, judge.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username);
    }

    @Override
    public String toString() {
        return "Judge{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
