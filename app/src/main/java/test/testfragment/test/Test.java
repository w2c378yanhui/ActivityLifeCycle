package test.testfragment.test;

import java.util.Arrays;

public class Test {
    private String com;
    private String ischeck;
    private String condition;
    private TestData[] data;
    private String nu;
    private String state;
    private String message;
    private String status;

    public String getCom() {
        return this.com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getIscheck() {
        return this.ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public TestData[] getData() {
        return this.data;
    }

    public void setData(TestData[] data) {
        this.data = data;
    }

    public String getNu() {
        return this.nu;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Test{" +
                "com='" + com + '\'' +
                ", ischeck='" + ischeck + '\'' +
                ", condition='" + condition + '\'' +
                ", data=" + Arrays.toString(data) +
                ", nu='" + nu + '\'' +
                ", state='" + state + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
