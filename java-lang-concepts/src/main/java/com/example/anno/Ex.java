package com.example.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Food{}

//---------------------------------------------------
// Hotel-1
//---------------------------------------------------

class HotelOne{
    @Food
    public String getFood1(){
        return "food-1";
    }
    @Food
    public String getFood2(){
        return "food-2";
    }
}

//---------------------------------------------------
// Hotel-2
//---------------------------------------------------

class HotelTwo{
    @Food
    public String getDish(){
        return "dish-1";
    }
}


//------------------------------------------------------
// Person
//------------------------------------------------------

class Person{
    public void eat(String hotelClass) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz=Class.forName(hotelClass);
        Object instance=clazz.newInstance();
        Method[] methods=clazz.getMethods();
        for(Method method:methods){
            Food food=method.getAnnotation(Food.class);
            if(food!=null){
                Object o=method.invoke(instance);
                System.out.println(o);
            }
        }
    }
}



public class Ex {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Person person=new Person();
        person.eat("com.example.anno.HotelTwo");
    }
}
