package com.manifest.corp

class Entry {

    static hasMany = [comments:Comment]

    String title
    String entry
    Date datePosted
    Date dateLastUpdated
    static constraints = {

    }

    static mapping = {
        sort datePosted: "desc"
    }

    def beforeInsert(){
        datePosted = new Date()
    }

    def beforeUpdate(){
        dateLastUpdated = new Date()
    }
}
