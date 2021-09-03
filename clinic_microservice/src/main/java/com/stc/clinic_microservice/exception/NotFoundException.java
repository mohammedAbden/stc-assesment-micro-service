package com.stc.clinic_microservice.exception;

public class NotFoundException extends  Exception{

    public NotFoundException(){
        super("Resource Not Found");
    }

}
