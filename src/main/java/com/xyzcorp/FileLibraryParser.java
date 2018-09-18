package com.xyzcorp;

import java.util.function.Function;
import java.util.stream.Stream;

public class FileLibraryParser {

    private final Function<String, Checkout> fun;

    public FileLibraryParser(Function<String, Checkout> fun) {
        this.fun = fun;
    }

    public Stream<Checkout> parseStream(Stream<String> stream) {
        return stream.map(fun);
    }
}
