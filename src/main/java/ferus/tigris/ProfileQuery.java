package ferus.tigris;

public class ProfileQuery implements ferus.tigris.IQuery {
    private final String measures;

    public ProfileQuery(String measures) {
        this.measures = measures;
    }

    @Override
    public String getQueryString() {
        return measures;
    }
}
