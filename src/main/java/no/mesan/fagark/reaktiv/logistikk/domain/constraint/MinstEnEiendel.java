package no.mesan.fagark.reaktiv.logistikk.domain.constraint;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import no.mesan.fagark.reaktiv.logistikk.domain.Eiendel;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MinstEnEiendel.Validator.class)
public @interface MinstEnEiendel {

    String message() default "{no.mesan.fagark.reaktiv.logistikk.domain.constraint.message.eiendel.mobil}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<MinstEnEiendel, List<Eiendel>>, Serializable {

        private static final long serialVersionUID = 1L;

        @Override
        public void initialize(final MinstEnEiendel hasId) {
        }

        @Override
        public boolean isValid(final List<Eiendel> eiendeler, final ConstraintValidatorContext constraintValidatorContext) {
            return !eiendeler.isEmpty();
        }
    }
}
