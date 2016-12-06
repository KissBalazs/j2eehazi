package hu.forest.jeehazi.service.converters;

import hu.forest.jeehazi.model.Car;
import hu.forest.jeehazi.service.CarService;

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
 *     PrimeFaces Converter megoldás a legördülő listából való kiválasztás, és utána ebből Kölcsönzés objektum létrehozásához.
 */
@Named("carConverter")
@ApplicationScoped
public class CarConverter implements Converter {

    @Inject
    private CarService carService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if(s==null || s.isEmpty()){
            return null;
        }
        Optional<Car> optinalCar = carService.getCars()
                .stream()
                .filter(currentCar -> currentCar.getPresentationName().equals(s))
                .findFirst();
        if (optinalCar.isPresent()) {
            return optinalCar.get();
        } else {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Nem találom az autót prezentációs név alapján"));
        }

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o==null){
            return null;
        }
        return (((Car) o).getPresentationName());
    }
}
