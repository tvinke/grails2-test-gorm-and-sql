package test

import grails.transaction.Transactional
import groovy.sql.Sql

/**
 *	Finds me some cats!
 */
@Transactional
class CatService {
	
    def findCatsByDomainClass() {
		Cat.list()
    }
	
    def dataSource
	def findCatsByGroovySQL() {
		new Sql(dataSource).rows("select * from cat")
	}
}
