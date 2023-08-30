import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ LexerTest.class, ParserTest.class})
public class AllTests {

}
