package hiyen;

import hiyen.ui.Console;
import java.util.ArrayList;
import java.util.List;

public class MockConsole implements Console {
    private List<String> inputs = new ArrayList<>();

    @Override
    public String read() {
        return null;
    }

    @Override
    public void print(final String message) {
        inputs.add(message);
    }

    public List<String> getInputs() {
        return inputs;
    }
}
