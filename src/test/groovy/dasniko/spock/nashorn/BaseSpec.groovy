package dasniko.spock.nashorn

import spock.lang.Specification

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
abstract class BaseSpec extends Specification {
    ScriptEngine nashorn = new ScriptEngineManager().getEngineByName('nashorn');
}
