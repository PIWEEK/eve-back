package eve.persistence

import groovy.sql.Sql

class Database {
    private static Database INSTANCE = new Database()
    Sql sql

    private Database() {
        this.sql = Sql.newInstance('jdbc:h2:devDb', 'sa', '')
    }

    static Database getInstance() {
        return INSTANCE
    }
}