package pojo;

public class PostLogInPOJO {
    private String login;
    private String password;

    public PostLogInPOJO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public PostLogInPOJO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
