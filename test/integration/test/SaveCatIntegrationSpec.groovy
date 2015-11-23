package test

import spock.lang.*
import groovy.sql.*

/**
 * Integration test when a cat is saved with domain class
 * and found back again with domain classes and Groovy SQL.
 */
class SaveCatIntegrationSpec extends Specification {
	
	def dataSource
	
	def catService

    def setup() {
		new Cat(name: "Mizzy").save()
		assert new Sql(dataSource).rows("select * from cat")[0].name == "Mizzy" 
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
