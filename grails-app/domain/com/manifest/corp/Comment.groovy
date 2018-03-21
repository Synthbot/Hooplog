package com.manifest.corp

class Comment {

    static belongsTo = [Entry]

    String title
    Entry entry
    Date date
    String comment

    def beforeInsert() {
        date = new Date()
    }

    static constraints = {

    }

    static mapping = {
        sort date: "desc"
    }
}
