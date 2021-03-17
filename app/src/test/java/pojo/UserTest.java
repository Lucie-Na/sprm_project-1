package pojo;

import org.junit.Test;
import java.time.LocalDate;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class UserTest {
    private final LocalDate date = LocalDate.now();

    @Test
    public void testSetFirstName_isCorrect() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            assertEquals("firstName", user.getFirstName());
        } catch (Exception e) {
            fail("Exception wasn't expected.");
        }
    }

    @Test
    public void testSetLastName_isCorrect() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            assertEquals("lastName", user.getLastName());
        } catch (Exception e) {
            fail("Exception wasn't expected.");
        }
    }

    @Test
    public void testSetGender_isCorrect() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            assertEquals("gender", user.getGender());
        } catch (Exception e) {
            fail("Exception wasn't expected.");
        }
    }

    @Test
    public void testSetDateOfBirth_isCorrect() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            assertEquals(date, user.getDateOfBirth());
        } catch (Exception e) {
            fail("Exception wasn't expected.");
        }
    }

    @Test
    public void testSetCountry_isCorrect() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            assertEquals(new String[] {"country"}, user.getCountry());
        } catch (Exception e) {
            fail("Exception wasn't expected.");
        }
    }

    @Test
    public void testSetZip_isCorrect() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            assertEquals("zipCode", user.getZip());
        } catch (Exception e) {
            fail("Exception wasn't expected.");
        }
    }

    @Test
    public void testSetCity_isCorrect() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            assertEquals("city", user.getCity());
        } catch (Exception e) {
            fail("Exception wasn't expected.");
        }
    }

    @Test
    public void testSetAddress_isCorrect() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            assertEquals("address", user.getAddress());
        } catch (Exception e) {
            fail("Exception wasn't expected.");
        }
    }

    @Test
    public void testSetPhoneNumber_isCorrect() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            assertEquals("phoneNumber", user.getPhoneNumber());
        } catch (Exception e) {
            fail("Exception wasn't expected.");
        }
    }

    @Test
    public void testSetEmail_isCorrect() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            assertEquals("email", user.getEmail());
        } catch (Exception e) {
            fail("Exception wasn't expected.");
        }
    }

    @Test
    public void testSetPassword_isCorrect() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            assertEquals("password", user.getPassword());
        } catch (Exception e) {
            fail("Exception wasn't expected.");
        }
    }

    @Test
    public void testSetFirstName_isEmpty() {
        try {
            User user = new User("", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            fail("An exception was expected.");
        } catch (Exception e) {
            assertFalse(Objects.requireNonNull(e.getMessage()).isEmpty());
        }
    }

    @Test
    public void testSetLastName_isEmpty() {
        try {
            User user = new User("firstName", "", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            fail("An exception was expected.");
        } catch (Exception e) {
            assertFalse(Objects.requireNonNull(e.getMessage()).isEmpty());
        }
    }

    @Test
    public void testSetGender_isEmpty() {
        try {
            User user = new User("firstName", "lastName", "",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            fail("An exception was expected.");
        } catch (Exception e) {
            assertFalse(Objects.requireNonNull(e.getMessage()).isEmpty());
        }
    }

    @Test
    public void testSetCountry_isNull() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {}, "zipCode", "city", "address",
                    "phoneNumber", "email", "password");
            fail("An exception was expected.");
        } catch (Exception e) {
            assertFalse(Objects.requireNonNull(e.getMessage()).isEmpty());
        }
    }

    @Test
    public void testSetZip_isEmpty() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "", "city", "address",
                    "phoneNumber", "email", "password");
            fail("An exception was expected.");
        } catch (Exception e) {
            assertFalse(Objects.requireNonNull(e.getMessage()).isEmpty());
        }
    }

    @Test
    public void testSetCity_isEmpty() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "", "address",
                    "phoneNumber", "email", "password");
            fail("An exception was expected.");
        } catch (Exception e) {
            assertFalse(Objects.requireNonNull(e.getMessage()).isEmpty());
        }
    }

    @Test
    public void testSetAddress_isEmpty() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "",
                    "phoneNumber", "email", "password");
            fail("An exception was expected.");
        } catch (Exception e) {
            assertFalse(Objects.requireNonNull(e.getMessage()).isEmpty());
        }
    }

    @Test
    public void testSetPhoneNumber_isEmpty() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "", "email", "password");
            fail("An exception was expected.");
        } catch (Exception e) {
            assertFalse(Objects.requireNonNull(e.getMessage()).isEmpty());
        }
    }

    @Test
    public void testSetEmail_isEmpty() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "", "password");
            fail("An exception was expected.");
        } catch (Exception e) {
            assertFalse(Objects.requireNonNull(e.getMessage()).isEmpty());
        }
    }

    @Test
    public void testSetPassword_isEmpty() {
        try {
            User user = new User("firstName", "lastName", "gender",
                    date, new String[] {"country"}, "zipCode", "city", "address",
                    "phoneNumber", "email", "");
            fail("An exception was expected.");
        } catch (Exception e) {
            assertFalse(Objects.requireNonNull(e.getMessage()).isEmpty());
        }
    }
}