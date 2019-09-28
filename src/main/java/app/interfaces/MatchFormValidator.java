package app.interfaces;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MatchFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return clazz.isAssignableFrom(MatchForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		MatchForm form = (MatchForm) target;

		if(form.getRedTeam().size() != 2 || form.getBlueTeam().size() != 2){
			errors.reject("team size != 2");
		}
	}
}
