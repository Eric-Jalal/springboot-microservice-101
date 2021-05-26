import com.jerilok.countriesapp.core.countries.CountriesProcessor;
import com.jerilok.countriesapp.core.countries.CountriesRepository;
import com.jerilok.countriesapp.core.countries.CountriesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CountriesServiceTest {

    @Mock
    private CountriesRepository countriesRepository;

    @Mock
    private CountriesProcessor countriesProcessor;

    private CountriesService countriesService;

    @Before
    public void init() {
        countriesService = new CountriesService(countriesRepository, countriesProcessor);
    }

    @Test
    public void testGetAllCountries() {
        when(countriesRepository.fetchAllCountries()).thenReturn(mockRawCountriesResponse());
        // TODO: Fix the test
        assertEquals(countriesService.getAllCountries(), expectedResponse());
    }

    private String expectedResponse() {
        return  "{\n" +
                "  \"countries\": [\n" +
                "    {\n" +
                "      \"name\": \"Afghanistan\",\n" +
                "      \"country_code\": \"AF\"\n" +
                "    }\n" +
                "]\n" +
                "}";
    }

    // Move this to a new file
    private String mockRawCountriesResponse() {
        return "[\n" +
                "    {\n" +
                "        \"name\": \"Afghanistan\",\n" +
                "        \"topLevelDomain\": [\n" +
                "            \".af\"\n" +
                "        ],\n" +
                "        \"alpha2Code\": \"AF\",\n" +
                "        \"alpha3Code\": \"AFG\",\n" +
                "        \"callingCodes\": [\n" +
                "            \"93\"\n" +
                "        ],\n" +
                "        \"capital\": \"Kabul\",\n" +
                "        \"altSpellings\": [\n" +
                "            \"AF\",\n" +
                "            \"Afġānistān\"\n" +
                "        ],\n" +
                "        \"region\": \"Asia\",\n" +
                "        \"subregion\": \"Southern Asia\",\n" +
                "        \"population\": 27657145,\n" +
                "        \"latlng\": [\n" +
                "            33.0,\n" +
                "            65.0\n" +
                "        ],\n" +
                "        \"demonym\": \"Afghan\",\n" +
                "        \"area\": 652230.0,\n" +
                "        \"gini\": 27.8,\n" +
                "        \"timezones\": [\n" +
                "            \"UTC+04:30\"\n" +
                "        ],\n" +
                "        \"borders\": [\n" +
                "            \"IRN\",\n" +
                "            \"PAK\",\n" +
                "            \"TKM\",\n" +
                "            \"UZB\",\n" +
                "            \"TJK\",\n" +
                "            \"CHN\"\n" +
                "        ],\n" +
                "        \"nativeName\": \"افغانستان\",\n" +
                "        \"numericCode\": \"004\",\n" +
                "        \"currencies\": [\n" +
                "            {\n" +
                "                \"code\": \"AFN\",\n" +
                "                \"name\": \"Afghan afghani\",\n" +
                "                \"symbol\": \"؋\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"languages\": [\n" +
                "            {\n" +
                "                \"iso639_1\": \"ps\",\n" +
                "                \"iso639_2\": \"pus\",\n" +
                "                \"name\": \"Pashto\",\n" +
                "                \"nativeName\": \"پښتو\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"iso639_1\": \"uz\",\n" +
                "                \"iso639_2\": \"uzb\",\n" +
                "                \"name\": \"Uzbek\",\n" +
                "                \"nativeName\": \"Oʻzbek\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"iso639_1\": \"tk\",\n" +
                "                \"iso639_2\": \"tuk\",\n" +
                "                \"name\": \"Turkmen\",\n" +
                "                \"nativeName\": \"Türkmen\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"translations\": {\n" +
                "            \"de\": \"Afghanistan\",\n" +
                "            \"es\": \"Afganistán\",\n" +
                "            \"fr\": \"Afghanistan\",\n" +
                "            \"ja\": \"アフガニスタン\",\n" +
                "            \"it\": \"Afghanistan\",\n" +
                "            \"br\": \"Afeganistão\",\n" +
                "            \"pt\": \"Afeganistão\",\n" +
                "            \"nl\": \"Afghanistan\",\n" +
                "            \"hr\": \"Afganistan\",\n" +
                "            \"fa\": \"افغانستان\"\n" +
                "        },\n" +
                "        \"flag\": \"https://restcountries.eu/data/afg.svg\",\n" +
                "        \"regionalBlocs\": [\n" +
                "            {\n" +
                "                \"acronym\": \"SAARC\",\n" +
                "                \"name\": \"South Asian Association for Regional Cooperation\",\n" +
                "                \"otherAcronyms\": [],\n" +
                "                \"otherNames\": []\n" +
                "            }\n" +
                "        ],\n" +
                "        \"cioc\": \"AFG\"\n" +
                "    }\n" +
                "]";
    }
}
