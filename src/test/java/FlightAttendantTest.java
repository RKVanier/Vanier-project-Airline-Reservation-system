import org.example.FlightAttendant;
import org.example.CrewMember;
import org.example.User;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FlightAttendantTest {

    @Test
    public void testCompareTo_SameClass_DifferentId() {
        CrewMember fa1 = new FlightAttendant("Anna", User.Gender.FEMALE, true, 100,
                FlightAttendant.Role.ASSISTANCE, Arrays.asList("English", "French"));
        CrewMember fa2 = new FlightAttendant("Beth", User.Gender.FEMALE, true, 100,
                FlightAttendant.Role.SECURITY, Arrays.asList("English"));

        assertTrue(fa1.compareTo(fa2) < 0);
        assertTrue(fa2.compareTo(fa1) > 0);
    }

    @Test
    public void testCompareTo_DifferentClass() {
        CrewMember fa = new FlightAttendant("Clara", User.Gender.FEMALE, true, 150,
                FlightAttendant.Role.COOK, Arrays.asList("Spanish"));
        CrewMember cm = new CrewMember("David", User.Gender.MALE, true, 200);

        assertTrue(fa.compareTo(cm) < 0);
    }

    @Test
    public void testCompareTo_EqualIds() {
        CrewMember fa1 = new FlightAttendant("Eva", User.Gender.FEMALE, true, 100,
                FlightAttendant.Role.EMERGENCY, Arrays.asList("English"));
        CrewMember fa2 = fa1;

        assertEquals(0, fa1.compareTo(fa2));
    }
}