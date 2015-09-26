package dasniko.spock.nashorn

import spock.lang.Shared
import spock.lang.Unroll

import javax.script.ScriptContext

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
abstract class JasmineSpec extends BaseSpec {

    @Shared def jasmineResults

    def setupSpec() {
        def scriptParams = [
                "__jasmineSpec__"    : getMetaClass().getMetaProperty("SPEC").getProperty(null),
                "__jasmineSpecName__": "${this.class.simpleName}.groovy"
        ]

        nashorn.getBindings(ScriptContext.ENGINE_SCOPE).putAll(scriptParams);
        jasmineResults = loadJS('/jasmine-bootstrap.js')
    }

    def isPassed(def specResult) {
        specResult.status == 'passed' || specResult.status == 'pending'
    }

    def specErrorMsg(def specResult) {
        specResult.failedExpectations.collect {it.value}.collect {it.stack}.join('\n\n\n')
    }

    @Unroll
    def "#specName"() {
        expect:
        assert isPassed(item), specErrorMsg(item)

        where:
        item << jasmineResults.collect {it.value}
        specName = (item.status != 'pending' ? item.fullName : "IGNORED: $item.fullName")
    }
}
