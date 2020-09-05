package Quest2;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/Cucumber/Features/quest2-test.feature",
        plugin = {"pretty", "html:out"}
//        glue = {"/src/test/java/Quest1/Quest1Test"}

        )

public class TestRunner_Quest2 {
}
//TODO: naprawić runner