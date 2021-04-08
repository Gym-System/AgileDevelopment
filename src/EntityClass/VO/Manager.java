package EntityClass.VO;

import java.util.Date;

public class Manager extends Staff {
    private int managerType = 0;

    public Manager(String userName, String password, String email) {
        super(userName, password, email);
    }

    public Manager(String userName, String password, String email, String gender, String telNo, Date doB, String companyName) {
        super(userName, password, email, gender, telNo, doB, companyName);
    }

    public int getManagerType() {
        return managerType;
    }

    public void setManagerType(int managerType) {
        this.managerType = managerType;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerType=" + managerType +
                "} " + super.toString();
    }
}
