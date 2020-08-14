package com.xyzcorp.instructor;

import java.util.List;
import java.util.Map;

public interface FindAllStudentsRegisteredService {
    Map<Character, List<Student>> groupByFirstLetterOfLastName();
}
