package exam.cristian.quasar.controller;

import exam.cristian.quasar.controllers.TopSecretSplitController;
import exam.cristian.quasar.repository.SatellitesRepository;
import exam.cristian.quasar.services.TopSecretSplit;
import exam.cristian.quasar.services.impl.TopSecretImpl;
import exam.cristian.quasar.services.impl.TopSecretSplitImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TopSecretSplitController.class)
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class TopSecretSplitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private TopSecretSplitController topSecretSplitController;

    @MockBean
    private TopSecretSplitImpl topSecretSplit;

    @MockBean
    private SatellitesRepository satellitesRepository;

    @MockBean
    private TopSecretImpl topSecret;

    @Test
    public void TestGetMessageLocation() throws Exception {

            Long cantidad = 2L;
            String url = "/topsecret_split";

            Mockito.when(topSecretSplit.count()).thenReturn(cantidad);

            mockMvc.perform(get(url)).andExpect(status().isNotFound());

    }

}
