package ua.hillel.ThesisObject.ApiObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
        private String id;
        private String username;
        private String name;
        private String lastname;
        private String password;
        private String confirmpassword;
}

