package dasniko.spock.nashorn

import spock.lang.Shared
import spock.lang.Specification

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
abstract class BaseSpec extends Specification {
    @Shared ScriptEngine nashorn = new ScriptEngineManager().getEngineByName('nashorn');

    def loadJS(String path) {
        return nashorn.eval(this.class.getResource(path).text)
    }
}
