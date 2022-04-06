package ua.hillel.ThesisObject.ApiObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Job {
      private Integer id;
      private String title;
      private String description;
      private Integer price;
      private String user;
      private Integer noOfComments;
}
