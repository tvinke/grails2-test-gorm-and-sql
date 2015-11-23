package test

import grails.buildtestdata.mixin.Build
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * 
 * Simple unit test which mocks the database when going through domain classes.
 * 
 * Uses the Build Test Data plugin.
 * 
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Cat)
@Build(Cat)
class BuildCatSpec extends Specification {

    def setup() {
		Cat.build(name: "Mizzy")
    }

    def cleanup() {
    }

    void "test list with domain classes"() {
    	def cats = Cat.list()
    	println "Cats: $cats"
		
		expect:
		cats
		cats[0].name == "Mizzy"
		cats.size() == 1
    }
}
