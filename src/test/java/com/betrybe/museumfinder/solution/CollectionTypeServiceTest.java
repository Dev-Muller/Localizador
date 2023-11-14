package com.betrybe.museumfinder.solution;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.service.CollectionTypeService;

@SpringBootTest
@AutoConfigureMockMvc
public class CollectionTypeServiceTest {
    
    @Autowired
    CollectionTypeService collectionTypeService;

    @MockBean
    MuseumFakeDatabase database;

    @Test
    public void testCountByCollectionTypes() {
        Mockito.when(database.countByCollectionType(Mockito.any())).thenReturn(10L);
        CollectionTypeService service = new CollectionTypeService(database);

        // service.countByCollectionTypes("Hist");

        assert(service.countByCollectionTypes("Hist").count() == 10L);
    }

    @Test
    public void testSplitTypesByComma() {
        Mockito.when(database.countByCollectionType(Mockito.any())).thenReturn(3L);
        CollectionTypeService service = new CollectionTypeService(database);


        assert(service.countByCollectionTypes("Hist, Art").count() == 6L);
    }
}
