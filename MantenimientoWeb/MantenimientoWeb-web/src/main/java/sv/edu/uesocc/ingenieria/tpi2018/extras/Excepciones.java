/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.extras;

/**
 *
 * @author ricky
 */
public class Excepciones extends RuntimeException {

    public Excepciones(String message) {
        super(message);
    }

    public Excepciones(Message message) {
        super(message.getErrorMessage());
    }

    public enum Message {
        NOTCREATED("REGISTRO NO CREADO"),
        NOTEDITED("REGISTRO NO FUE EDITADO"),
        NOTDELETED("REGISTRO NO ELIMINADO"),
        NOTFOUND("REGISTRO NO ENCONTRADO"),
        IDNOTFOUND("EL REGISTRO CON EL ID PROPORCIONADO NO FUE ENCONTRADO"),
        REPEATED("REGISTRO REPETIDO"),
        REQFIELD("RELLENE TODOS LOS CAMPOS OBLIGATORIOS"),
        INVPAR("TIENE UN PARAMETRO INVALIDO");

        private final String errorMessage;

        private Message(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

    }

}
