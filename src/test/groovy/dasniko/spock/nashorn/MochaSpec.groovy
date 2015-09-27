package dasniko.spock.nashorn

import spock.lang.Shared

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
class MochaSpec extends BaseSpec {

    @Shared def mochaResults

    def setupSpec() {
        mochaResults = loadJS('/mocha-bootstrap.js')
    }

    def "mochaRun"() {
        expect:
        true == true
    }

}
