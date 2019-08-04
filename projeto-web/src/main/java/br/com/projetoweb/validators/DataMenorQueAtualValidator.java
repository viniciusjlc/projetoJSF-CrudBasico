package br.com.projetoweb.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@FacesValidator ("DataMenorQueAtualValidator")
public class DataMenorQueAtualValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Date Data = (Date) value;

		if (!isDatalValid(Data)) {
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "A data não pode ser maior que a atual.", "Erro de validação"));
		}
	}

	public static boolean isDatalValid(Date data) {
		boolean isDataValid = false;

		if(data == null) {
			return true;
		}
		
		if (data.before(retornarDataAtual())) {
			isDataValid = true;
		}
		return isDataValid;
	}

	public static Date retornarDataAtual() {
		Calendar calendar = new GregorianCalendar();
		Date date = new Date();
		calendar.setTime(date);
		return calendar.getTime();
	}

}