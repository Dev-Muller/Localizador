package com.betrybe.museumfinder.solution;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static com.betrybe.museumfinder.evaluation.utils.TestHelpers.createMockMuseum;
import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.model.Museum;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
public class MuseumControllerTest {
    
  @MockBean
  MuseumServiceInterface service;
  
  @Autowired
  MockMvc mockMvc;

  @Test
  public void getMuseumByIdOk () throws Exception {
    Museum museum = createMockMuseum(10L);
    Mockito.when(service.getMuseum(10L)).thenReturn(museum);
    mockMvc.perform(get("/museums/10").accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());
  }
}
