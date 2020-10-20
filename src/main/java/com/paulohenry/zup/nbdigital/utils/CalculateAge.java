package com.paulohenry.zup.nbdigital.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.paulohenry.zup.nbdigital.validation.ValidationAge;



public class CalculateAge implements ConstraintValidator<ValidationAge, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      Boolean res = calcule(value);      
      return res;      
    }
    @Override
    public void initialize(ValidationAge constraintAnnotation) {
      constraintAnnotation.message();
      
    }

        public Boolean calcule(String dataNascimento) {

      
          GregorianCalendar hoje = new GregorianCalendar();
          int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);
          int mesAtual = hoje.get(Calendar.MONTH) + 1;
          int anoAtual = hoje.get(Calendar.YEAR);

          
          int diaNascimento = Integer.valueOf(dataNascimento.substring(0,2));
          int mesNascimento = Integer.valueOf(dataNascimento.substring(3,5));
          int anoNascimento = Integer.valueOf(dataNascimento.substring(6,10));

          // Idade.
          int resultado;

          if (mesNascimento < mesAtual || (mesNascimento == mesAtual && diaNascimento <= diaAtual)){
            resultado = anoAtual - anoNascimento;
            System.out.println("if" + resultado);    
          }else{
            resultado = (anoAtual - mesNascimento)-1;
            
          }

          if(resultado<18){
            return false;
          }else{
            return true;
          }          
          
      }

}


