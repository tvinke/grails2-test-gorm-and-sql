package test

import spock.lang.*
import groovy.sql.*

/**
 * Integration test when a cat is built with Build Test Data plugin
 * and found back again with domain classes and Groovy SQL.
 */
// do NOT use @Build(Cat) here - since we're in a integration test
class BuildCatIntegrationSpec extends Specification {
	
	def catService

    def setup() {
		Cat.build(name: "Mizzy")
    }

    def cleanup() {
    }

    void "test list with domain classes"() {
    	def cats = catService.findCatsByDomainClass()
    	println "Cats: $cats"
		
		expect:
		cats
		cats[0].name == "Mizzy"
		cats.size() == 1
    }
	
	void "test list with Groovy SQL"() {
		def rows = catService.findCatsByGroovySQL()
		println "Rows: $rows"

		expect:
		rows
		rows[0].name == "Mizzy"
		rows.size() == 1
	}
}
