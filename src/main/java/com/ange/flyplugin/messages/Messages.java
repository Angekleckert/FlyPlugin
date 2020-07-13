package com.ange.flyplugin.messages;

import com.ange.flyplugin.FlyPlugin;
import lombok.Getter;

public enum Messages {

    FLY_ENABLED("§7Fliegen wurde aktiviert!", "§7Fly has been enabled!", "§7Полет активирован!", "§7¡El vuelo ha sido activado!"),

    NO_PERMISSION("§7Du hast keine Rechte für diesen Befehl!", "§7You have no permission to execute this command!", "§7Вы не имеете права отдавать этот приказ!", "§7¡No tienes derecho a dar esa orden!"),

    FLY_DISABLED("§7Fliegen wurde deaktiviert!", "§7Fly has been disabled!", "§7Летать было дезактивировано!", "§7¡El vuelo ha sido activado!");

    @Getter
    private String messageGER;
    @Getter
    private String messageENG;
    @Getter
    private String messageRUS;
    @Getter
    private String messageSPAN;

    Messages (String messageGER, String messageENG, String messageRUS, String messageSPAN) {
        this.messageGER = messageGER;
        this.messageENG = messageENG;
        this.messageRUS = messageRUS;
        this.messageSPAN = messageSPAN;
    }

    public String getMessage () {
        String lang = FlyPlugin.getInstance().getLanguage();
        String prefix = FlyPlugin.getInstance().getPrefix();

        switch (lang) {
            case "deu":
                return prefix + getMessageGER();
            case "rus":
                return prefix + getMessageRUS();
            case "span":
                return prefix + getMessageSPAN();
            default:
                return prefix + getMessageENG();
        }

    }

}
