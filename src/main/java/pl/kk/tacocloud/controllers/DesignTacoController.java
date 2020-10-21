package pl.kk.tacocloud.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;
import pl.kk.tacocloud.models.Ingredient;
import pl.kk.tacocloud.models.Taco;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "oats", Ingredient.Type.WRAP),
                new Ingredient("COTO", "corn", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "meat chunks", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "chopped tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LECT", "lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "salsa", Ingredient.Type.SAUCE),
                new Ingredient("YOGH", "yoghurt", Ingredient.Type.SAUCE)
        );
        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type:types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        model.addAttribute("design", new Taco());
        return "design";
    }

    private static List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {

        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors) {
        if (errors.hasErrors()){
            return "redirect:/design"; //TODO zapytać o wyświetlenie błędu, jak to zrobić bez redirect
        }
        log.info("Processing taco design: " + design);
        return "redirect:/orders/current";
    }
}