package com.blog

import grails.plugins.springsecurity.Secured

import org.springframework.dao.DataIntegrityViolationException

class EntryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 1, 1)
        [entryInstanceList: Post.list(params), entryInstanceTotal: Post.count()]
    }

    @Secured(['ROLE_BLOGGER'])
    def create() {
        [entryInstance: new Post(params)]
    }

    @Secured(['ROLE_BLOGGER'])
    def save() {
        def entryInstance = new Entry(params)
        if (!entryInstance.save(flush: true)) {
            render(view: "create", model: [entryInstance: entryInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'entry.label', default: 'Entry'), entryInstance.id])
        redirect(action: "show", id: entryInstance.id)
    }

    def show() {
        def entryInstance = Entry.get(params.id)
        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'entry.label', default: 'Entry'), params.id])
            redirect(action: "list")
            return
        }

        [entryInstance: entryInstance]
    }

    @Secured(['ROLE_BLOGGER'])
    def edit() {
        def entryInstance = Entry.get(params.id)
        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'entry.label', default: 'Entry'), params.id])
            redirect(action: "list")
            return
        }

        [entryInstance: entryInstance]
    }

    @Secured(['ROLE_BLOGGER'])
    def update() {
        def entryInstance = Entry.get(params.id)
        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'entry.label', default: 'Entry'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (entryInstance.version > version) {
                entryInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'entry.label', default: 'Entry')] as Object[],
                        "Another user has updated this Entry while you were editing")
                render(view: "edit", model: [entryInstance: entryInstance])
                return
            }
        }

        entryInstance.properties = params

        if (!entryInstance.save(flush: true)) {
            render(view: "edit", model: [entryInstance: entryInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'entry.label', default: 'Entry'), entryInstance.id])
        redirect(action: "show", id: entryInstance.id)
    }

    @Secured(['ROLE_BLOGGER'])
    def delete() {
        def entryInstance = Entry.get(params.id)
        if (!entryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'entry.label', default: 'Entry'), params.id])
            redirect(action: "list")
            return
        }

        try {
            entryInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'entry.label', default: 'Entry'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'entry.label', default: 'Entry'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}