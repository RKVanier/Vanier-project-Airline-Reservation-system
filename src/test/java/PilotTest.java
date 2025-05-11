
import org.example.Pilot;
import org.example.CrewMember;
import org.example.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PilotTest {

    @Test
    public void testCompareTo_SameClass_DifferentId() {
        CrewMember p1 = new Pilot("John", User.Gender.MALE, true, 300, true, Pilot.CockpitRole.PILOT);
        CrewMember p2 = new Pilot("Mike", User.Gender.MALE, true, 300, false, Pilot.CockpitRole.COPILOT);
        assertTrue(p1.compareTo(p2) < 0);
        assertTrue(p2.compareTo(p1) > 0);
    }

    @Test
    public void testCompareTo_SameObject() {
        Pilot p1 = new Pilot("Sara", User.Gender.FEMALE, false, 250, true, Pilot.CockpitRole.COPILOT);
        assertEquals(0, p1.compareTo(p1));
    }

    @Test
    public void testCompareTo_DifferentClass() {
        CrewMember p1 = new Pilot("Tom", User.Gender.MALE, false, 400, false, Pilot.CockpitRole.PILOT);
        CrewMember cm = new CrewMember("David", User.Gender.MALE, false, 300);
        assertTrue(p1.compareTo(cm) > 0);
    }
}