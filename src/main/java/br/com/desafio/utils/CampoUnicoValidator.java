package br.com.desafio.utils;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CampoUnicoValidator implements ConstraintValidator<CampoUnico, Object> {

    @PersistenceContext
    private EntityManager entityManager;
    private String name;
    private Class<?> klazz;

    @Override
    public void initialize(CampoUnico value) {
        name = value.name();
        klazz = value.klazz();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + klazz.getName() + " WHERE " + name + "=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1, "Foi encontrado mais de um atributo " + name + " = " + value);

        return list.isEmpty();
    }
}
