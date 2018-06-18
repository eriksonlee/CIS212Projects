package example.identification;

import example.common.InvalidDataException;

public class IdentifiableImpl implements Identifiable {

    private String identifier;

    public IdentifiableImpl(String id) throws InvalidDataException {
        setIdentifier(id);
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    public final void setIdentifier(String id) throws InvalidDataException {
        if (id == null || id.length() == 0) {
            throw new InvalidDataException("Null or empty ID passed to setIdentifier");
        }
        identifier = id;
    }
}
