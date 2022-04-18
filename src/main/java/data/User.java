package data;

public class User {
    private String name;
    private String login;
    private String password;
    private Long id;


    public User(){

    }

    public User(String name, String login,String password,Long id){
        this.name = name;
        this.login = login;
        this.password = password;
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login){
        this.login  = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static class UserBuilder{
        private User user;

        public UserBuilder(){
            this.user = new User();
        }

        public UserBuilder setLogin(String login){
            user.login = login;
            return this;
        }
        public UserBuilder setPassword(String password){
            user.password =password;
            return  this;
        }

        public UserBuilder setFullName(String name){
            user.name = name;
            return this;
        }

        public UserBuilder setId(Long id){
            user.id = id;
            return this;
        }

        public User build(){
            return user;
        }
    }
}


