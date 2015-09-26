package dasniko.spock.nashorn

import java.util.function.Function

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
class CallbackSpec extends BaseSpec {

    def "callback"() {
        given:
        nashorn.eval('function callMe(callback) { return callback("") + " Doe"; }')

        when:
        def result = nashorn.invokeFunction('callMe', { return 'John' } as Function)

        then:
        result == 'John Doe'
    }

    def "mocked callback"() {
        given:
        nashorn.eval('function callMe(callback) { return callback("") + " Doe"; }')
        def callback = Mock(Function)

        when:
        def result = nashorn.invokeFunction('callMe', callback)

        then:
        1 * callback.apply('') >> 'John'
        result == 'John Doe'
    }

    def "alert"() {
        given:
        nashorn.eval('function alertMe() { alert("Huh!"); }')
        def alert = Mock(Function)
        nashorn.put('alert', alert)

        when:
        nashorn.invokeFunction('alertMe')

        then:
        1 * alert.apply('Huh!')
    }

}
