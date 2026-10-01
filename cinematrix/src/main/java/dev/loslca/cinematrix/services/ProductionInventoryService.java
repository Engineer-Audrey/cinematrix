package dev.loslca.cinematrix.services;

import dev.loslca.cinematrix.model.dto.ProductionDTO;
import dev.loslca.cinematrix.model.entity.Movie;
import dev.loslca.cinematrix.model.entity.Production;
import dev.loslca.cinematrix.repository.MovieRepository;
import dev.loslca.cinematrix.repository.ProductionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductionInventoryService {

    private final ProductionRepository repository;
    private final MovieRepository movieRepository;

    public ProductionInventoryService(ProductionRepository repository, MovieRepository movieRepository) {
        this.repository = repository;
        this.movieRepository = movieRepository;
    }

    public List<Production> findAllProductions() {
        return this.repository.findAll();
    }

    public List<Production> findProductionsByMovieTitle(String title) {
        return this.repository.findByMovieTitleContainingIgnoreCase(title);
    }

    public Optional<Production> findProductionsByMovieId(Long movieId) {
        return this.repository.findByMovieId(movieId);
    }

    public List<Production> findProductionsByBudget(Double budget) {
        return this.repository.findByBudget(budget);
    }

    public List<Production> findProductionsByActualCost(Double actualCost) {
        return this.repository.findByActualCost(actualCost);
    }

    public ProductionDTO createProduction(ProductionDTO productionRequest) throws EntityNotFoundException {
        Movie movie = findMovie(productionRequest.movie());
        Production production = new Production();
        setAttributesFromDTO(productionRequest, production, movie);
        this.repository.save(production);
        return productionRequest;
    }

    public ProductionDTO updateProduction(Long productionId, ProductionDTO productionRequest) throws EntityNotFoundException {
        Production production = this.repository.findById(productionId)
                .orElseThrow(() -> new EntityNotFoundException("Production with id " + productionId + " not found"));
        Movie movie = findMovie(productionRequest.movie());
        setAttributesFromDTO(productionRequest, production, movie);
        this.repository.save(production);
        return productionRequest;
    }

    public void deleteProduction(Long productionId) throws EntityNotFoundException {
        Production production = this.repository.findById(productionId)
                .orElseThrow(() -> new EntityNotFoundException("Production with id " + productionId + " not found"));
        this.repository.delete(production);
    }

    public void setAttributesFromDTO(ProductionDTO request, Production production, Movie movie) {
        production.setBudget(request.budget());
        production.setActualCost(request.actualCost());
        if (movie != null) {
            production.setMovie(movie);
        }
    }

    public Movie findMovie(String movieTitle) throws EntityNotFoundException {
        if (movieTitle == null) {
            return null;
        }
        return this.movieRepository.findByTitleIgnoreCase(movieTitle)
                .orElseThrow(() -> new EntityNotFoundException("Movie with title " + movieTitle + " not found"));
    }
}