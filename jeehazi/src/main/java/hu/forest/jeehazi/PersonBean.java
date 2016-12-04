package hu.forest.jeehazi;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */


@Slf4j
@ManagedBean
@SessionScoped
public class PersonBean implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
