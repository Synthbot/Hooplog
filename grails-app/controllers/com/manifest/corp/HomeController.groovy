package com.manifest.corp

class HomeController {

    def index() {
        [mostRecentEntries : Entry.list([max:10])]
    }
}
