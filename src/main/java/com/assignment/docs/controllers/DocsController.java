package com.assignment.docs.controllers;

import com.assignment.docs.entities.Docs;
import com.assignment.docs.links.DocsLinks;
import com.assignment.docs.services.DocsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/docs/")
public class DocsController {

    @Autowired
    DocsService docsService;

    @CrossOrigin(origins = {"http://localhost:3000"})
    @GetMapping(path = DocsLinks.LIST_DOCS)
    public ResponseEntity<?> listDocs() throws IOException {
        List<Docs> resource = docsService.getDocs();
        return ResponseEntity.ok(resource);
    }

    @PostMapping(path = DocsLinks.DELETE_DOCS)
    public ResponseEntity<?> deleteDocs(@RequestBody Docs doc) {
        boolean isDeleted = docsService.deleteDocs(doc);
        return ResponseEntity.ok(isDeleted);
    }

}
