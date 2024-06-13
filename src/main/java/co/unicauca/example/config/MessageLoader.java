package co.unicauca.example.config;

import jakarta.enterprise.context.ApplicationScoped;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Provides message handling functionality through a ResourceBundle.
 */
@ApplicationScoped
public class MessageLoader {
    private static final String MESSAGE_PROPERTIES = "messages";
    private final ResourceBundle bundle;
    private static MessageLoader instance;

    private MessageLoader() {
        Locale locale = new Locale("es", "ES");
        this.bundle = ResourceBundle.getBundle(MESSAGE_PROPERTIES, locale);
    }

    public static  MessageLoader getInstance(){
        if (Objects.isNull(instance)){
            instance = new MessageLoader();
        }
        return instance;
    }

    /**
     * Retrieves the message associated with the provided code.
     *
     * @param code The code of the message to retrieve.
     * @param params Optional parameters to format the retrieved message.
     * @return The formatted message string.
     */
    public String getMessage(String code, Object... params ) {
        return MessageFormat.format(bundle.getString(code), params);
    }
}
