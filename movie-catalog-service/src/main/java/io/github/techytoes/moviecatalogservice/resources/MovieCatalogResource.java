package io.github.techytoes.moviecatalogservice.resources;

import io.github.techytoes.moviecatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @RequestMapping("/{userID}")
    public List<CatalogItem> getCatalog(@PathVariable("userID") String userID) {
        return Collections.singletonList(
                new CatalogItem("Interstellar", "Some Sci-Fi", 5)
        );
    }
}
