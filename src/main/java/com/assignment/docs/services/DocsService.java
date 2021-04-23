package com.assignment.docs.services;

import com.assignment.docs.entities.Docs;
import com.assignment.docs.recordStructure.DateFormat;
import com.assignment.docs.recordStructure.FieldSizes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DocsService {

    @Value("${data.location}")
    private Resource resourceLocation;

    public List<Docs> getDocs() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceLocation.getInputStream()));
        List<Docs> list = new ArrayList<>();
        int id = 0;
        while (reader.ready()) {
            String line = reader.readLine();
            if (!line.isEmpty()) list.add(parseDocsFromString(line, id++));
        }
        return list;
    }

    public boolean deleteDocs(Docs doc) {
        return false;
    }

    private Docs parseDocsFromString(String line, int id) {
        int indexBegin = 0;
        int indexEnd = indexBegin + FieldSizes.DOCTYPE_SIZE;
        String docType = line.substring(indexBegin, indexEnd);
        indexBegin = indexEnd;
        indexEnd += FieldSizes.COMPANYID_SIZE;
        int companyID = Integer.parseInt(line.substring(indexBegin, indexEnd));
        indexBegin = indexEnd;
        indexEnd += FieldSizes.DATE_SIZE;
        LocalDate date = LocalDate.parse(line.substring(indexBegin, indexEnd), DateFormat.formatter);
        indexBegin = indexEnd;
        indexEnd += FieldSizes.DOCID_SIZE;
        int docId = Integer.parseInt(line.substring(indexBegin, indexEnd));
        indexBegin = indexEnd;
        indexEnd += FieldSizes.SIGN_SIZE;
        String sign = line.substring(indexBegin, indexEnd);
        indexBegin = indexEnd;
        indexEnd += FieldSizes.AMOUNT_SIZE;
        int amount = Integer.parseInt(line.substring(indexBegin, indexEnd));
        return new Docs(id, docType, companyID, date, docId, sign, amount);
    }

}
