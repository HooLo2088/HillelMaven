package ua.hillel.ThesisObject.ApiObject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Array;

@Getter
@Setter
@ToString
public class Image {
    private Integer id;
    private String name;
    private String image;
    private String message;
}
