package pl.kk.tacocloud.repositories;

import pl.kk.tacocloud.models.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);

}
