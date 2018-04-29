/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.tpi2018.web.exceptions;

/**
 *
 * @author danm
 */
public enum EnumControllerException {
    
    FALTA_CAMPO_REQUERIDO("Falta un campo obligatorio"),
    REGISTRO_REPETIDO("El registro no se pudo crear porque ya existe"),
    COULD_NOT_DELETE_USER_PROFILE("Could not delete user profile"),
    NO_RECORD_FOUND("No record found for provided id"),
    RECORD_ALREADY_EXISTS("Record already exists"),
    INTERNAL_SERVER_ERROR("Something went wrong. Please repeat this operation later.");
    
    private String errorMessage;
    
    private EnumControllerException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    
    

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    
    
    
    
    
}
