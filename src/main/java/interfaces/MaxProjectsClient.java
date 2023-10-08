package interfaces;

public class MaxProjectsClient {
    private String NAME;
    private int PROJECT_COUNT;

    public String getName() {
        return NAME;
    }

    public void setName(String NAME) {
        this.NAME = NAME;
    }

    public int getProjectCount() {
        return PROJECT_COUNT;
    }

    public void setProjectCount(int PROJECT_COUNT) {
        this.PROJECT_COUNT = PROJECT_COUNT;
    }
}
