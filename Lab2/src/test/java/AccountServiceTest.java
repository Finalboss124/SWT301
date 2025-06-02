import baolt.example.AccountService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceTest {

    private final AccountService service = new AccountService();

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testRegisterAccount(String username, String password, String email, boolean expected) {
        boolean actual = service.registerAccount(username, password, email);
        assertEquals(expected, actual,
                String.format("Failed for: username='%s', password='%s', email='%s'", username, password, email));
    }
}
