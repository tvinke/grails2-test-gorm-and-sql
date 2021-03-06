package test

import spock.lang.*
import groovy.sql.*

/**
 * Integration test when a cat is inserted with Groovy SQL
 * and found back again with domain classes and Groovy SQL.
 */
class InsertCatIntegrationSpec extends Specification {
	
	def dataSource
	def sql
	
	def catService

    def setup() {
		sql = new Sql(dataSource)
		sql.execute """
			INSERT INTO cat (name, version) VALUES ('Mizzy', 1)
		"""
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
