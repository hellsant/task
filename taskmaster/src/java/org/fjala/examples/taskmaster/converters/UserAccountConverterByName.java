/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fjala.examples.taskmaster.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import org.fjala.examples.taskmaster.model.UserAccount;
import org.fjala.examples.taskmaster.services.ProjectService;

/**
 *
 * @author douglas
 */
@FacesConverter("userAccountConverterByName")
public class UserAccountConverterByName implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                ProjectService service = context.getApplication().evaluateExpressionGet(context, "#{projectService}", ProjectService.class);
                return service.findUserByName(value);
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid name."));
            }
        } else {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      String userTemplate = "%s %s";
        if(value != null && (value instanceof UserAccount)){
            UserAccount user = (UserAccount) value;
            return String.format(userTemplate,user.getName(), user.getLastName());
        }
        return null;
    }
}
