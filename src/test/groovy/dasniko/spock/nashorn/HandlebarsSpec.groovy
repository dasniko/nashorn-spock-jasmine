package dasniko.spock.nashorn

import spock.lang.Unroll

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
class HandlebarsSpec extends BaseSpec {

    def setupSpec() {
        loadJS('/handlebars/dist/handlebars.js')
        loadJS('/handlebars_template_renderer.js')
    }

    @Unroll
    def "template for #expected"() {
        given:
        def template = this.class.getResource('/hello.handlebars').text

        expect:
        nashorn.invokeFunction('render', template, model) == expected

        where:
        model                                | expected
        [name: [first: 'John', last: 'Doe']] | 'Hello, John Doe!'
        [name: [last: 'World']]              | 'Hello,  World!'
    }
}
