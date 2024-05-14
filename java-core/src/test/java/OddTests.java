import org.junit.jupiter.api.Test;
import ru.qa.school.core.OddTask;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class OddTests {
    @Test
    public void testOdd() {
        assertFalse(OddTask.isOdd(2));
    }
}
