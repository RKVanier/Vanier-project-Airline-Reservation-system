import org.example.CrewMember;
import org.example.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrewMemberTest {

    @Test
    public void testCompareTo_LessThan() {
        CrewMember cm1 = new CrewMember("Alice", User.Gender.FEMALE, true, 100);
        CrewMember cm2 = new CrewMember("Bob", User.Gender.MALE, false, 200);
        assertTrue(cm1.compareTo(cm2) < 0);
    }

    @Test
    public void testCompareTo_GreaterThan() {
        CrewMember cm1 = new CrewMember("Alice", User.Gender.FEMALE, true, 300);
        CrewMember cm2 = new CrewMember("Bob", User.Gender.MALE, false, 100);
        assertTrue(cm1.compareTo(cm2) > 0);
    }

    @Test
    public void testCompareTo_Equal() {
        CrewMember cm1 = new CrewMember("Alice", User.Gender.FEMALE, true, 150);
        CrewMember cm2 = new CrewMember("Bob", User.Gender.MALE, false, 150);
        assertEquals(0, cm1.compareTo(cm2));
    }
}