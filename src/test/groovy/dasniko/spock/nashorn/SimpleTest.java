package dasniko.spock.nashorn;

import org.junit.Assert;
import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
public class SimpleTest {

    ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");

    @Test
    public void testSimple() throws ScriptException {
        Object result = nashorn.eval("1 + 1");
        Assert.assertEquals(2, result);
    }

}
