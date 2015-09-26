package dasniko.spock.nashorn

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
class JasmineCalculatorSpec extends JasmineSpec {
    static def SPEC = this.class.getResource('/jasmine-testsuite.js').text
}
