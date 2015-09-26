package dasniko.spock.nashorn

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
class SimpleSpec extends BaseSpec {

    def "simple"() {
        when:
        def result = nashorn.eval('1 + 1')

        then:
        result == 2
    }

}
