package gui.widgets.inputs;

import javafx.scene.AccessibleAttribute;
import javafx.scene.AccessibleRole;
import javafx.scene.paint.Color;

/**
 *  Created by nima on 5/17/16.
 */
public class ColoredPasswordField extends ColoredTextField {


    public ColoredPasswordField(Color color) {
        super(color);
        getStyleClass().add("password-field");
        setAccessibleRole(AccessibleRole.PASSWORD_FIELD);
    }

    /***************************************************************************
     *                                                                         *
     * Methods                                                                 *
     *                                                                         *
     **************************************************************************/

    /**
     * Does nothing for PasswordField.
     */
    @Override public void cut() {
        // No-op
    }

    /**
     * Does nothing for PasswordField.
     */
    @Override public void copy() {
        // No-op
    }


    /***************************************************************************
     *                                                                         *
     * Accessibility handling                                                  *
     *                                                                         *
     **************************************************************************/

    @Override
    public Object queryAccessibleAttribute(AccessibleAttribute attribute, Object... parameters) {
        switch (attribute) {
            case TEXT: return null;
            default: return super.queryAccessibleAttribute(attribute, parameters);
        }
    }
}

