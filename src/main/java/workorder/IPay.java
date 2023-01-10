package workorder;

import exception.InvalidPayingMethodException;

public interface IPay {
    void pay(Integer id) throws InvalidPayingMethodException;
}
