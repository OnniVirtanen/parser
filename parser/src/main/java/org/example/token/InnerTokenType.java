package org.example.token;

public interface InnerTokenType<T extends InnerTokenType> {

    int getValue();

    T[] getValues();

    default T getType(int value) {
        for (T type : getValues()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }

}
