package dasniko.spock.nashorn

import spock.lang.Unroll

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
class CalculatorSpec extends BaseSpec {

    def setup() {
        loadJS('/calculator.js')
    }

    def "add"() {
        when:
        def result = nashorn.invokeFunction('add', 1, 2)

        then:
        result == 3
    }

    @Unroll
    def "square of #a is #expected"() {
        when:
        def result = nashorn.invokeFunction('square', a)

        then:
        result == expected

        where:
        a | expected
        1 | 1
        2 | 4
        3 | 9
        4 | 16
    }

}
