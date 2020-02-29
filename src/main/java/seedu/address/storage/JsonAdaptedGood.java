package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.good.Good;
import seedu.address.model.good.GoodName;


/**
 * Jackson-friendly version of {@link Good}.
 */
class JsonAdaptedGood {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Good's %s field is missing!";

    private final String goodName;

    /**
     * Constructs a {@code JsonAdaptedGood} with the given good details.
     */
    @JsonCreator
    public JsonAdaptedGood(@JsonProperty("goodName") String goodName) {
        this.goodName = goodName;
    }

    /**
     * Converts a given {@code Good} into this class for Jackson use.
     */
    public JsonAdaptedGood(Good source) {
        goodName = source.getGoodName().fullGoodName;
    }

    /**
     * Converts this Jackson-friendly adapted good object into the model's {@code Good} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted good.
     */
    public Good toModelType() throws IllegalValueException {
        if (goodName == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    GoodName.class.getSimpleName()));
        }
        if (!GoodName.isValidGoodName(goodName)) {
            throw new IllegalValueException(GoodName.MESSAGE_CONSTRAINTS);
        }
        final GoodName modelGoodName = new GoodName(goodName);
        return new Good(modelGoodName);
    }

}
