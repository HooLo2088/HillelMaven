package ua.hillel.ThesisObject.ApiObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Comment {
    private Integer id;
    private String message;
    private String username;
    private String commentDate;
}
