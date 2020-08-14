package com.xyzcorp.instructor;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FindAllStudentsRegisteredStandardService implements FindAllStudentsRegisteredService {

    private final Function<String, List<Student>> f;

    public FindAllStudentsRegisteredStandardService(Function<String, List<Student>> f) {
        this.f = f;
    }

    @Override
    public Map<Character, List<Student>> groupByFirstLetterOfLastName() {
        f.apply("Foo");
        return null;
    }
}
