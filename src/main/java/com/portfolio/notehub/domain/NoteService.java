package com.portfolio.notehub.domain;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class NoteService {

    @PersistenceContext(unitName = "notehubPU")
    private EntityManager em;


    public NoteService() {}

    @Transactional
    public Note createNote(String title, String content) {
        Note note = new Note(title, content);
        em.persist(note);
        return note;
    }


    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Note> listNotes() {
        return em.createQuery("SELECT n FROM Note n ORDER BY n.createdAt DESC", Note.class)
                .getResultList();
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public Optional<Note> getNote(Long id) {
        return Optional.ofNullable(em.find(Note.class, id));
    }

    @Transactional
    public boolean deleteNote(Long id) {
        Note note = em.find(Note.class, id);
        if (note == null) {
            return false;
        }
        em.remove(note);
        return true;
    }
}