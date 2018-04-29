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
public class ControllerException extends RuntimeException {

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(Message message) {
        super(message.getErrorMessage());
    }

    public enum Message {
        PARAMETRO_INVALIDO("Uno o mas parametros ingresados son invalidos"),
        FALTA_CAMPO_REQUERIDO("Falta un campo obligatorio"),
        REGISTRO_NO_CREADO("Registro no creado"),
        REGISTRO_REPETIDO("El registro no se pudo crear porque ya existe"),
        REGISTRO_NO_ELIMINADO("No se pudo eliminar el registro"),
        REGISTRO_NO_EDITADO("No se pudo editar el registro"),
        REGISTRO_NO_ENCONTRADO("No se encontraron registros para los datos provistos"),
        ID_NO_ENCONTRADO("No se encontro el id especificado"),
        NO_HAY_REGISTROS("No se encontraron registros de la entidad");

        private String errorMessage;

        private Message(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

    }

}
