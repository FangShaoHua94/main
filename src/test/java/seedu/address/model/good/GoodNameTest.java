package seedu.address.model.good;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class GoodNameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new GoodName(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new GoodName(invalidName));
    }

    @Test
    public void isValidName() {
        // null name
        assertThrows(NullPointerException.class, () -> GoodName.isValidGoodName(null));

        // invalid name
        assertFalse(GoodName.isValidGoodName("")); // empty string
        assertFalse(GoodName.isValidGoodName(" ")); // spaces only
        assertFalse(GoodName.isValidGoodName("^")); // only non-alphanumeric characters
        assertFalse(GoodName.isValidGoodName("apple*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(GoodName.isValidGoodName("fuji apple")); // alphabets only
        assertTrue(GoodName.isValidGoodName("12345")); // numbers only
        assertTrue(GoodName.isValidGoodName("2nd Gen fuji apple")); // alphanumeric characters
        assertTrue(GoodName.isValidGoodName("Fuji apple")); // with capital letters
        assertTrue(GoodName.isValidGoodName("fuji apple with very very very long name")); // long names
    }
}
