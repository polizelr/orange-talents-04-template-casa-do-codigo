package br.com.zupacademy.rafaela.casadocodigo.config.validation;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {
    private String fieldName;
    private Class<?> aClass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistsId constraintAnnotation) {
        aClass = constraintAnnotation.domainClass();
        fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("select 1 from "+aClass.getName()+" where "+fieldName+"=:value");
        query.setParameter("value", o);
        List<?> resultList = query.getResultList();
        Assert.state(!resultList.isEmpty(),  aClass +" com o atributo "+ fieldName+" = "+o + " não cadastrado(a)");

        return !resultList.isEmpty();
    }
}