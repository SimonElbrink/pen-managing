package se.lexicon.simon.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * @Author Simon Elbrink
 *
 */
public class Pen implements Serializable {

    private UUID id;
    private String partNumber;
    private String model;
    private String color;

    /**
     * No-args constructor / Default constructor
     * This Constructor is added because it's needed for some functionality in Jackson. (Also needed later in Java EE)
     */
    public Pen() {
        super();
    }

    /**
     * Id is fetched from UUID.randomUUID
     * @param partNumber String
     * @param model String
     * @param color String
     */
    public Pen(String partNumber, String model, String color) {
        this(UUID.randomUUID(),partNumber,model,color);
    }

    /**
     * All Args constructor - Covers all fields created.
     * @param id
     * @param partNumber
     * @param model
     * @param color
     */
    public Pen(UUID id, String partNumber, String model, String color) {
        this.id = id;
        setPartNumber(partNumber);
        setModel(model);
        setColor(color);
    }

    public UUID getId() {
        return id;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return Objects.equals(id, pen.id) &&
                Objects.equals(partNumber, pen.partNumber) &&
                Objects.equals(model, pen.model) &&
                Objects.equals(color, pen.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partNumber, model, color);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pen{");
        sb.append("id=").append(id);
        sb.append(", partNumber='").append(partNumber).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
