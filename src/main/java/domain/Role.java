package domain;

/**
 * Created by Kocherha Vitalii on 18.12.2017.
 */
public enum Role {
    USER(1),
    ADMIN(2),
    ANON(3);

    private final int roleId;

    Role(int id) {
        this.roleId = id;
    }

    public static Role getById(int id) {
        Role role = ANON;
        for (Role r : Role.values()){
            if (r.roleId == id){
                role = r;
            }
        }
        return role;
    }
}
