package com.mperapoch.randomnames;

import net.codestory.http.annotations.Get;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by marcal.perapoch on 08/07/16.
 */
public class RandomNamesResource {

    private static final List<String> NAMES = Arrays.asList("pepe", "jordi", "miquel");
    private static final Random RANDOM = new Random();

    @Get("/generate")
    public String generateRandomName() {
        return "pepe";
    }

    @Get("/generate/:howmany")
    public List<String> generateNRandomNames(int howMany) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < howMany; ++i) {
            result.add(NAMES.get(RANDOM.nextInt(NAMES.size())));
        }
        return result;
    }
}
