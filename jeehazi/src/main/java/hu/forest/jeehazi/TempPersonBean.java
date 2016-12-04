package hu.forest.jeehazi;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@Named // menedzselt bean
@SessionScoped // életciklus
public class TempPersonBean implements Serializable { // kötelező a serializable sessionscoped-nél ugye

    @Setter
    @Getter
    private String name;
}
