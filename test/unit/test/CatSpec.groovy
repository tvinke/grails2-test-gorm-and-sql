package test

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * 
 * Simple unit test which mocks the database when going through domain classes.
 * 
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Cat)
class CatSpec extends Specification {

    def setup() {
		new Cat(name: "Mizzy").save()
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
