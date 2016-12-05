package hu.forest.jeehazi.service.converters;

import hu.forest.jeehazi.model.User;
import hu.forest.jeehazi.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

/**
 * @author Kiss Balázs <balazs.kiss@webvalto.hu>
 */

@Named("userConverter")
@ApplicationScoped
public class UserConverter implements Converter {

    @Inject
    private UserService userService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Optional<User> optionalUser = userService.getUsers()
                .stream()
                .filter(currentUser -> currentUser.getName().equals(s))
                .findFirst();

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "nem találom a usert név alapján"));
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return ((User) o).getName();
    }
}