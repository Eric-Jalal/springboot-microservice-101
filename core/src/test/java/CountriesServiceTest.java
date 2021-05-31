import com.jerilok.countriesapp.core.countries.CountriesProcessor;
import com.jerilok.countriesapp.core.countries.CountriesRepository;
import com.jerilok.countriesapp.model.Country;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CountriesProcessor.class)
public class CountriesServiceTest {

    @Mock
    private CountriesRepository countriesRepository;

    @Autowired
    private CountriesProcessor countriesProcessor;

    @Before
    public void init() {

    }

    @Test
    public void testGetAllCountriesReturnsObjectName() {
//        Map<String, List<Country>> countries = countriesProcessor.getAllCountries(countriesList);
//        assertNotNull(countries.get("countries"));
    }
}
}
