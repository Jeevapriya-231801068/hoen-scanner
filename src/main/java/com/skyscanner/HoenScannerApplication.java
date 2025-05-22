import com.skyscanner.HoenScannerConfiguration;
import io.dropwizard.setup.Environment;

import com.hoenscanner.api.SearchResult;
import com.hoenscanner.resources.SearchResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import io.dropwizard.setup.Environment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hoenscanner.api.SearchResult;
import com.hoenscanner.resources.SearchResource;

public void run(HoenScannerConfiguration configuration, Environment environment) throws Exception {
    // Create a Jackson ObjectMapper for JSON parsing
    ObjectMapper mapper = new ObjectMapper();

    // List to hold all search results
    List<SearchResult> searchResults = new ArrayList<>();

    // Load rental cars data
    searchResults.addAll(Arrays.asList(mapper.readValue(
            Resources.getResource("rental_cars.json"), SearchResult[].class)));

    // Load hotels data
    searchResults.addAll(Arrays.asList(mapper.readValue(
            Resources.getResource("hotels.json"), SearchResult[].class)));

    // Register the resource that handles search requests
    final SearchResource resource = new SearchResource(searchResults);
    environment.jersey().register(resource);
}
@Override
public void run(HoenScannerConfiguration configuration, Environment environment) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    List<SearchResult> searchResults = new ArrayList<>();

    searchResults.addAll(Arrays.asList(mapper.readValue(
            Resources.getResource("rental_cars.json"), SearchResult[].class)));
    searchResults.addAll(Arrays.asList(mapper.readValue(
            Resources.getResource("hotels.json"), SearchResult[].class)));

    // Register resource here
    final SearchResource resource = new SearchResource(searchResults);
    environment.jersey().register(resource);
}
