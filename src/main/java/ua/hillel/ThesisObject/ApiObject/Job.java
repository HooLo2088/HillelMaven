package ua.hillel.ThesisObject.ApiObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Job {
    private Integer id;
    private String title;
    private String description;
    private Double price;
    private String user;
    private Integer noOfComments;
}
