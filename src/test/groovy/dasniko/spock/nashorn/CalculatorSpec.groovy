package dasniko.spock.nashorn

import spock.lang.Unroll

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
class CalculatorSpec extends BaseSpec {

    def setup() {
        def calc = this.class.getResource('/calculator.js').text
        nashorn.eval(calc)
    }

    def "add"() {
        when:
        def result = nashorn.invokeFunction('add', 1, 2)

        then:
        result == 3
    }

    @Unroll
    def "square of #no is #sq"() {
        when:
        def result = nashorn.invokeFunction('square', no)

        then:
        result == sq

        where:
        no | sq
        1  | 1
        2  | 4
        3  | 9
        4  | 16
    }

}
