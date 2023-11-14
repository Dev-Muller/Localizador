package com.betrybe.museumfinder.solution;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.service.CollectionTypeService;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
public class CollectionTypeCrontrollerTest {
  
  @MockBean
  CollectionTypeService service;
  
  @Autowired
  MockMvc mockMvc;

  @Test
  void testController() throws Exception {
    Mockito.when(service.countByCollectionTypes(Mockito.any())).thenReturn(new CollectionTypeCount(new String[] {"Hist"}, 10L));
    mockMvc.perform(get("/collections/count/Hist").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    Mockito.verify(service).countByCollectionTypes(Mockito.any());
  }

  @Test
  void testFailedController() throws Exception {
    Mockito.when(service.countByCollectionTypes(Mockito.any())).thenReturn(new CollectionTypeCount(new String[] {"Asdf"}, 0));
    mockMvc.perform(get("/collections/count/Asdf").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
    Mockito.verify(service).countByCollectionTypes(Mockito.any());
  }
}
