package com.xyzcorp.instructor;

import java.time.LocalDate;
import java.util.Objects;

public class LibraryRecord {
    private final String name;
    private final String title;
    private final LocalDate checkoutDate;

    public LibraryRecord(String name, String title, LocalDate checkoutDate) {
        this.name = name;
        this.title = title;
        this.checkoutDate = checkoutDate;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LibraryRecord(name=");
        sb.append(name);
        sb.append(",title=");
        sb.append(title);
        sb.append(",checkoutDate=");
        sb.append(checkoutDate.toString());
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LibraryRecord)) return false;
        LibraryRecord other = (LibraryRecord) obj;
        return Objects.equals(this.checkoutDate, other.checkoutDate) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.title, other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, title, checkoutDate);
    }
}
