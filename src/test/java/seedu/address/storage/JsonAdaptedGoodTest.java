package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedGood.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalGoods.BANANA;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.good.GoodName;

public class JsonAdaptedGoodTest {
    private static final String INVALID_GOOD_NAME = "A@pple";

    @Test
    public void toModelType_validGoodDetails_returnsGood() throws Exception {
        JsonAdaptedGood good = new JsonAdaptedGood(BANANA);
        assertEquals(BANANA, good.toModelType());
    }

    @Test
    public void toModelType_invalidGoodName_throwsIllegalValueException() {
        JsonAdaptedGood good =
                new JsonAdaptedGood(INVALID_GOOD_NAME);
        String expectedMessage = GoodName.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, good::toModelType);
    }

    @Test
    public void toModelType_nullGoodName_throwsIllegalValueException() {
        JsonAdaptedGood good = new JsonAdaptedGood((String) null);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, GoodName.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, good::toModelType);
    }

}
