package br.com.projetoweb.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.projetoweb.util.VerificadorUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator ("EmailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String email = (String) value;

        if (!VerificadorUtil.estaNuloOuVazio(email)) {
            if (!isEmailValid(email)) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email inválido.", "Email inválido."));
            }
        }
    }


    private static boolean isEmailValid(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

}