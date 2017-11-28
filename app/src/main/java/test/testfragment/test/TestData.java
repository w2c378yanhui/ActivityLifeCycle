package test.testfragment.test;

public class TestData {
    private String ftime;
    private String context;
    private Object location;
    private String time;

    public String getFtime() {
        return this.ftime;
    }

    public void setFtime(String ftime) {
        this.ftime = ftime;
    }

    public String getContext() {
        return this.context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Object getLocation() {
        return this.location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "ftime='" + ftime + '\'' +
                ", context='" + context + '\'' +
                ", location=" + location +
                ", time='" + time + '\'' +
                '}';
    }
}
